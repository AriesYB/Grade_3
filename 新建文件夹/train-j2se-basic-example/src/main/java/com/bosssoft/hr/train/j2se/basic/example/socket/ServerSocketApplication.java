package com.bosssoft.hr.train.j2se.basic.example.socket;

/**
 * @author HetFrame
 * @Description 启动服务端
 * @date 2020/5/31 21:57
 */
public class ServerSocketApplication {
    public static  void main(String[] args){
        Starter serverSocket=new NioServerSocket();
        serverSocket.start();
    }
}
