package com.bosssoft.hr.train.j2se.basic.example.socket;

/**
 * @author HetFrame
 * @Description 启动客户端
 * @date 2020/5/31 21:57
 */
public class ClientSocketApplication {
    public static  void main(String[] args){
        Starter clientSocket=new ClientSocket();
        clientSocket.start();
    }
}
