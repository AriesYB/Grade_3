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

void loadData();

void loadData()
{
    typedef struct record
    {
        int id1;
        int id2;
        int amount;
    }Record;
    Record *recd;
    struct stat buf;
    int fd = open("/test_data.txt", O_RDONLY);//打开文件
    if (fd == -1)
    {
        cout << "打开文件失败!" << endl;
        exit(1);
    }
    fstat(fd, &buf);
    recd = (record*)mmap(0,buf.st_size,PROT_READ,MAP_SHARED,fd,0);//映射文件到内存
    close(fd);//映射完毕后关闭文件
    cout<<recd[0];   
}