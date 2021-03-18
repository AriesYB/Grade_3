# -*- coding: utf-8 -*-
"""
Created on Mon Oct 21 20:42:43 2019

@author: 管理员
"""

import numpy as np
import matplotlib.pyplot as plt
plt.rcParams['font.sans-serif']='SimHei'
plt.rcParams['axes.unicode_minus']=False
data=np.load("D:\\codes\\python\\国民经济核算季度数据.npz")
name=data['columns']
values=data['values']
plt.figure(figsize=(9,7))
plt.scatter(values[:,0],values[:,2],marker='o')
np.max(values[:,2])
plt.xlabel("年份")
plt.ylabel("生产总值（亿元）")
plt.ylim((0,225000))
plt.xticks(range(0,70,4),values[range(0,70,4),1],rotation=45)
# rotation标签旋转角度
plt.title("2000~2017各季度国民生产总值散点图")
plt.show()

###绘制多个散点
plt.figure(figsize=(9,7))
plt.scatter(values[:,0],values[:,3],marker='o',c='red')
plt.scatter(values[:,0],values[:,4],marker='D',c='green')
plt.scatter(values[:,0],values[:,5],marker='>',c='blue')
plt.xlabel('年');plt.ylabel('生产总值（亿）')
plt.xticks(range(0,70,4),values[range(0,70,4),1],rotation=45)
plt.title("打字好累啊，来回切换输入法")
plt.legend(["一产业","二产业","三产业"])
plt.show()
