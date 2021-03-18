#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include <cmath>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/stat.h>

using namespace std;

class LR
{
private:
    string train_file;
    string test_file;
    string result_file;
    double **data_train;        //训练集
    double **data_test;         //测试集
    double *train_row;          //训练集行
    double *test_row;           //测试集行
    int row_default_size_train; //训练集默认行数
    int row_default_size_test;  //测试集默认行数
    int col_default_size_train; //列默认大小
    int row_train;              //训练集行数
    int row_test;               //测试集行数
    int featuresNum;            //特征数(列数)
    int col_current;            //读文件时的当前列
    double ALPHA;               //学习率
    double *weight;             //权重值
    double *result;             //预测结果
    double *temp;               //临时

public:
    LR();
    void loadTrainData();
    void loadTestData();
    void addTrainToRow(double item, bool isNewLine);
    void addTestToRow(double item, bool isNewLine);
    double wTx(int row);
    double sigmoid(double z);
    double cost();
    void train(int k);
    void predict();
    void outputPredictData();
    void check();
    ~LR();
};

LR::LR()
{
    row_train = 0;
    row_test = 0;
    featuresNum = 0;
    col_current = 0;
    row_default_size_train = 1000;
    row_default_size_test = 1000;
    col_default_size_train = 100;
    ALPHA = 0.01;
    data_train = NULL;
    data_test = NULL;
    weight = NULL;
    result = NULL;
}
void LR::loadTrainData()
{
    data_train = new double *[row_default_size_train];
    train_row = new double[col_default_size_train];
    //内存映射文件
    struct stat buf;
    char *p_map = NULL;                              //映射文件后的指针
    int fd = open("/data/train_data.txt", O_RDONLY); //打开文件
    if (fd == -1)
    {
        cout << "打开文件失败" << endl;
        exit(1);
    }
    fstat(fd, &buf);
    //进行文件映射
    p_map = (char *)mmap(0, buf.st_size, PROT_READ, MAP_SHARED, fd, 0);
    close(fd); //映射后文件数据在内存中可以直接关闭文件
    if (p_map == NULL)
    {
        cout << "文件映射失败" << endl;
        exit(1);
    }
    int k = 0;
    char chs[5]; //存储char，以便转成double
    double temp; //转换后的double
    for (int i = 0; i < buf.st_size; i++)
    {
        chs[k] = p_map[i];
        //换行符
        if (p_map[i] == '\n')
        {
            temp = atof(chs);
            addTrainToRow(temp, true);
            char chs[5];
            k = 0;
            continue;
        }
        if (p_map[i] == ',')
        {
            //temp = strtod(chs,NULL);
            temp = atof(chs);
            addTrainToRow(temp, false);
            char chs[5];
            k = 0;
            continue;
        }
        k++;
    }
    munmap(p_map, buf.st_size);
}

void LR::loadTestData()
{
    data_test = new double *[row_default_size_test];
    test_row = new double[featuresNum];
    col_current = 0;
    struct stat buf;
    char *p_map = NULL;
    int fd = open("/data/test_data.txt", O_RDONLY);
    if (fd == -1)
    {
        cout << "打开测试文件失败" << endl;
        exit(1);
    }
    fstat(fd, &buf);
    p_map = (char *)mmap(0, buf.st_size, PROT_READ, MAP_SHARED, fd, 0);
    close(fd);
    if (p_map == NULL)
    {
        cout << "文件映射失败" << endl;
        exit(1);
    }
    int k = 0;
    char chs[5];
    double temp;
    for (int i = 0; i < buf.st_size; i++)
    {
        chs[k] = p_map[i];
        if (p_map[i] == '\n')
        {
            temp = atof(chs);
            addTestToRow(temp, true);
            char chs[5];
            k = 0;
            continue;
        }
        if (p_map[i] == ',')
        {
            temp = atof(chs);
            addTestToRow(temp, false);
            char chs[5];
            k = 0;
            continue;
        }
        k++;
    }
    munmap(p_map, buf.st_size);
}

void LR::addTrainToRow(double item, bool isNewLine)
{
    if (isNewLine)
    {
        //换行就知道特征数了就更新特征数(此时为999)
        if (featuresNum == 0)
        {
            featuresNum = col_current;
        }
        //train_data扩容
        if (row_train + 1 > row_default_size_train)
        {
            row_default_size_train = 2 * row_default_size_train;
            double **temp = new double *[row_default_size_train];
            for (int i = 0; i < row_train; i++)
            {
                temp[i] = data_train[i];
            }
            delete[] data_train;
            data_train = NULL;
            data_train = temp;
        }
        //当前数据其实是最后一列即标签
        train_row[featuresNum] = item;
        data_train[row_train] = train_row;
        //新的一行，列清0
        train_row = new double[featuresNum + 1];
        row_train++;
        col_current = 0;
    }
    else
    {
        //featuresNum为0说明在读第一行，因而可能需要扩容
        if (featuresNum == 0 && col_current + 1 > col_default_size_train)
        {
            //扩充行数组
            col_default_size_train = 2 * col_default_size_train;
            double *temp = new double[col_default_size_train];
            for (int i = 0; i < col_current; i++)
            {
                temp[i] = train_row[i];
            }
            delete[] train_row;
            train_row = NULL;
            train_row = temp;
        }
        train_row[col_current] = item;
        col_current++;
    }
}

void LR::addTestToRow(double item, bool isNewLine)
{
    if (isNewLine)
    {
        if (row_test + 1 > row_default_size_test)
        {
            row_default_size_test = 2 * row_default_size_test;
            double **temp = new double *[row_default_size_test];
            for (int i = 0; i < row_test; i++)
            {
                temp[i] = data_test[i];
            }
            delete[] data_test;
            data_test = NULL;
            data_test = temp;
        }
        test_row[col_current] = item;
        data_test[row_test] = test_row;
        test_row = new double[featuresNum];
        row_test++;
        col_current = 0;
    }
    else
    {
        test_row[col_current] = item;
        col_current++;
    }
}

double LR::wTx(int row)
{
    //w的转置乘以x得到数量积
    double temp = 0;
    for (int i = 0; i < featuresNum; i++)
    {
        temp += weight[i] * data_train[row][i];
    }
    temp += weight[featuresNum];
    return temp;
}
double LR::sigmoid(double z)
{
    return (double)1 / (1 + exp(-z));
}
void LR::train(int k)
{
    //进行初始化
    //最后一列为截距
    weight = new double[featuresNum + 1];
    temp = new double[featuresNum];
    for (int i = 0; i <= featuresNum; i++)
    {
        weight[i] = 0;
        temp[i] = 0;
    }
    result = new double[row_test];

    clock_t time1 = clock();
    //训练k次
    for (int n = 0; n < k; n++)
    {
        double temp2 = 0;
        for (int i = 0; i < row_train; i += 4)
        {
            for (int j = 0; j < featuresNum; j++)
            {
                temp[j] += (data_train[i][featuresNum] - sigmoid(wTx(i))) * data_train[i][j];
                weight[j] += ALPHA * temp[j];
            }
            temp2 += (data_train[i][featuresNum] - sigmoid(wTx(i)));
        }
        weight[featuresNum] += ALPHA * temp2;
        
    }
}
void LR::predict()
{
    int count = 0;
    for (int i = 0; i < row_test; i++)
    {
        double z = 0; //每行数据与权重的数量积
        for (int j = 0; j < featuresNum; j++)
        {
            z += weight[j] * data_test[i][j];
        }
        z += weight[featuresNum];
        double p = sigmoid(z); //概率
        result[i] = p;
    }
    for (int i = 0; i < row_test; i++)
    {
        if (result[i] > 0)
        {
            result[i] = 1;
        }
        else
        {
            result[i] = 0;
        }
    }
}
void LR::outputPredictData()
{
    ofstream outs("/projects/student/result.txt");
    for (int i = 0; i < row_test; i++)
    {
        outs << result[i];
        outs.put('\n');
    }
    outs.close();
}

LR::~LR()
{

    for (int i = 0; i < row_train; i++)
    {
        if (data_train[i] != NULL)
        {
            delete[] data_train[i];
            data_train[i] = NULL;
        }
    }
    if (data_train != NULL)
    {
        delete[] data_train;
        data_train = NULL;
    }
    for (int i = 0; i < row_test; i++)
    {
        if (data_test[i] != NULL)
        {
            delete[] data_test[i];
            data_test[i] = NULL;
        }
    }
    if (data_test != NULL)
    {
        delete[] data_test;
        data_test = NULL;
    }
    if (result != NULL)
    {
        delete[] result;
        result = NULL;
    }

    if (weight != NULL)
    {
        delete[] weight;
        weight = NULL;
    }
}

int main(int argc, char const *argv[])
{
    LR l;
    l.loadTrainData();
    l.loadTestData();
    l.train(1);
    l.predict();
    l.outputPredictData();

    return 0;
}
