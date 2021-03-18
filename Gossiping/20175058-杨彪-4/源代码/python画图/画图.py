# -*- coding: utf-8 -*-
"""
Created on Mon Oct 21 19:43:22 2019

@author: 管理员
"""
import numpy as np
import matplotlib.pyplot as plt
plt.rcParams['font.sans-serif'] = 'SimHei'#设置显示中文
#读取文件 节点数 误差 轮数 k值
result = np.loadtxt("result.txt",delimiter=",")
result1 = np.loadtxt("result1.txt",delimiter=",")
#整理数据
node_num = result[:,0]
error = result[:,1]
count = result[:,2]

error1 = result1[:,1]
count1 = result1[:,2]
k = result1[:,3]
#创建画布
fig1=plt.figure(figsize=(30,15))
fig2=plt.figure(figsize=(30,15))
#创建子图
subplot_p1=fig1.add_subplot(111)#画布有2个子图
subplot_p2=subplot_p1.twinx()
subplot_p3=fig2.add_subplot(111)
subplot_p4=subplot_p3.twinx()

#设置子图标题
subplot_p1.set_title('误差、轮数跟节点数的关系',color='blue',fontsize='xx-large')
subplot_p3.set_title('误差、轮数跟k值的关系',color='blue',fontsize='xx-large')
#在相应的子图内添加图
p1=subplot_p1.scatter(node_num,error,c='red')
p2=subplot_p2.scatter(node_num,count,c='blue')

p3=subplot_p3.scatter(k,error1,c='red')
p4=subplot_p4.scatter(k,count1,c='blue')

#修改横坐标
subplot_p1.set_xlabel('节点数量')
subplot_p1.set_ylabel('误差',color='red')
subplot_p2.set_ylabel('轮数',color='blue')
subplot_p3.set_xlabel('k值')
subplot_p3.set_ylabel('误差',color='red')
subplot_p4.set_ylabel('轮数',color='blue')

#在各个子图中添加图例
subplot_p1.legend([p1],labels=['误差'],loc='upper left')
subplot_p2.legend([p2],labels=['轮数'],loc='upper right')
subplot_p3.legend([p3],labels=['误差'],loc='upper left')
subplot_p4.legend([p4],labels=['轮数'],loc='upper right')
#显示画布
plt.show()
