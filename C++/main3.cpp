#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include <cmath>
#include <ctime>
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
    void readTrainData();
    void loadTrainData();
    void loadTestData();
    void addTrainToRow(double item, bool isNewLine);
    void addTestToRow(double item, bool isNewLine);
    void readTestData();
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
    ALPHA = 0.006;
    data_train = NULL;
    data_test = NULL;
    weight = NULL;
    result = NULL;
}
void LR::loadTrainData()
{
    data_train = new double *[row_default_size_train];
    train_row = new double[col_default_size_train];
    clock_t time1 = clock();
    //内存映射文件
    struct stat buf;
    char *p_map = NULL;                            //映射文件后的指针
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
    clock_t time2 = clock();
    cout << "read train file time:" << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl;
}

void LR::loadTestData()
{
    data_test = new double *[row_default_size_test];
    test_row = new double[featuresNum];
    col_current = 0;
    clock_t time1 = clock();
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
    clock_t time2 = clock();
    cout << "read test file time:" << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl;
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

void LR::readTrainData()
{
    data_train = new double *[row_default_size_train];
    clock_t time1 = clock();
    string line;
    //读文件
    ifstream inf(train_file.c_str());
    if (!inf)
    {
        cout << "打开训练文件失败" << endl;
        return;
    }
    while (inf.peek() != EOF)
    {
        //创建该行数组
        train_row = new double[col_default_size_train];
        //获取一行字符串
        getline(inf, line);
        if (line.empty())
        {
            continue;
        }
        //分割字符串
        int col_num = 0;
        int temp = 0;
        string::size_type pos = 0;
        while (true)
        {
            pos = line.find(",", temp);
            if (pos == string::npos)
            {
                break;
            }
            if (featuresNum == 0 && col_num + 1 > col_default_size_train)
            {
                //扩充行数组
                col_default_size_train = 2 * col_default_size_train;
                double *temp = new double[col_default_size_train];
                for (int i = 0; i < col_num; i++)
                {
                    temp[i] = train_row[i];
                }
                delete[] train_row;
                train_row = NULL;
                train_row = temp;
            }
            train_row[col_num] = atof((line.substr(temp, pos - temp)).c_str());
            temp = pos + 1;
            col_num++;
        }
        train_row[col_num] = atof((line.substr(temp, line.length())).c_str());
        //知道了列数、固定行数组大小
        if (featuresNum == 0)
        {
            featuresNum = col_num;
            col_default_size_train = featuresNum + 1;
        }
        //当前行数据数组指针存入data中
        //当前行数已经大于预设
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
        data_train[row_train] = train_row;
        row_train++;
    }
    clock_t time2 = clock();
    cout << "The read train data time is: " << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl;
    inf.close();
}
void LR::readTestData()
{
    data_test = new double *[row_default_size_test];
    clock_t time1 = clock();
    string line;
    //读文件
    ifstream inf(test_file.c_str());
    if (!inf)
    {
        cout << "打开训练文件失败" << endl;
        return;
    }
    while (inf.peek() != EOF)
    {
        //创建该行数组
        test_row = new double[featuresNum];
        //获取一行字符串
        getline(inf, line);
        if (line.empty())
        {
            continue;
        }
        //分割字符串
        int col_num = 0;
        int temp = 0;
        string::size_type pos = 0;
        while (true)
        {
            pos = line.find(",", temp);
            if (pos == string::npos)
            {
                break;
            }
            test_row[col_num] = atof(line.substr(temp, pos - temp).c_str());
            temp = pos + 1;
            col_num++;
        }
        test_row[col_num] = atof((line.substr(temp, line.length())).c_str());
        //当前行数据数组指针存入data中
        //当前行数已经大于预设
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
        data_test[row_test] = test_row;
        row_test++;
    }
    clock_t time2 = clock();
    cout << "The read test data time is: " << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl
         << endl;
    inf.close();
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
double LR::cost()
{
    clock_t time1 = clock();
    //损失函数J(w) = -sum(yi * log(s(zi)) + (1 - yi) * log(1 - s(zi)))  yi表示第i行的标签，s表示sigmoid(),zi表示第i行的wTx
    double temp = 0;
    for (int i = 0; i < row_train; i++)
    {
        temp += data_train[i][featuresNum] * log(sigmoid(wTx(i))) + (1 - data_train[i][featuresNum]) * log(1 - sigmoid(wTx(i)));
    }
    clock_t time2 = clock();
    cout << "the cost time:" << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl;
    return -temp / row_train;
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
        for (int j = 0; j < featuresNum; j++)
        {
            for (int i = 0; i < row_train; i+=7)
            {
                temp[j] += (data_train[i][featuresNum] - sigmoid(wTx(i))) * data_train[i][j];
            }
	    weight[j]+=ALPHA * temp[j];
        }
        /*for (int i = 0; i < row_train; i+=7)
        {
            for (int j = 0; j < featuresNum; j++)
            {
                temp[j] += (data_train[i][featuresNum] - sigmoid(wTx(i))) * data_train[i][j];
                weight[j] += ALPHA * temp[j];
            }
        }*/

        for (int i = 0; i < row_train; i+=7)
        {
            temp2 += (data_train[i][featuresNum] - sigmoid(wTx(i)));
        }
        weight[featuresNum] += ALPHA * temp2;
        // cout << "Now k=" << n << " cost:" << cost() << endl;
    }
    clock_t time2 = clock();
    cout << "train time:" << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl;
}
void LR::predict()
{
    clock_t time1 = clock();
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
        if (result[i] - 0.5 > 1e-6)
        {
            result[i] = 1;
        }
        else
        {
            result[i] = 0;
        }
    }
    clock_t time2 = clock();
    cout << "The predict spend time is:" << (double)(time2 - time1) / CLOCKS_PER_SEC << "s" << endl;
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
void LR::check()
{
    ifstream inf("/data/answer.txt");
    double *answer = new double[row_test];
    string line;
    int i = 0;
    while (inf)
    {
        getline(inf, line);
        if (line.empty())
        {
            continue;
        }

        answer[i] = atof(line.c_str());
        i++;
    }
    inf.close();

    int k = 0;
    for (int i = 0; i < row_test; i++)
    {
        if (result[i] == answer[i])
        {
            k++;
        }
    }

    cout << "zhunquelv:" << (double)k / row_test << endl;
    delete[] answer;
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
    cout << "start train" << endl;
    l.train(1);
    cout << "finish train" << endl;
    cout << "start predict" << endl;
    l.predict();
    cout << "finish predict" << endl;
    cout << "start check" << endl;
    l.check();
    cout << "finish check" << endl;
    cout << "start output" << endl;
    l.outputPredictData();
    cout << "finish output" << endl;
    system("pause");

    return 0;
}
