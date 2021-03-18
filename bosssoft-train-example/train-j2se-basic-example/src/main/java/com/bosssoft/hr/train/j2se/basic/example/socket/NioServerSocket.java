package com.bosssoft.hr.train.j2se.basic.example.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Calendar;
import java.util.Iterator;

/**
 * @author HetFrame
 * @Description 服务端
 * @date 2020/5/31 21:57
 */
@Slf4j
public class NioServerSocket implements Starter {

    private static final int PORT = 6789;

    private static final String LINE = "------------------------------------------------";

    @Override
    public boolean start() {
        ServerSocketChannel serverSocket = null;
        try {
            //服务初始化
            serverSocket = ServerSocketChannel.open();
            //设置为非阻塞
            serverSocket.configureBlocking(false);
            //绑定端口
            serverSocket.bind(new InetSocketAddress("localhost", PORT));
            //注册OP_ACCEPT事件（即监听该事件，如果有客户端发来连接请求，则该键在select()后被选中）
            Selector selector = Selector.open();
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            Calendar ca = Calendar.getInstance();
            log.info("服务端启动");
            log.info(LINE);
            //轮询服务
            int flag = 0;
            while (flag < 100) {
                //选择准备好的事件
                selector.select();
                //已选择的键集
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                //处理已选择键集事件
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    //处理掉后将键移除，避免重复消费(因为下次选择后，还在已选择键集中)
                    it.remove();
                    //处理连接请求
                    if (key.isAcceptable()) {
                        //处理请求
                        SocketChannel socket = serverSocket.accept();
                        socket.configureBlocking(false);
                        //注册read，监听客户端发送的消息
                        socket.register(selector, SelectionKey.OP_READ);
                        //keys为所有键，除掉serverSocket注册的键就是已连接socketChannel的数量
                        String message = "Hello Client" + (selector.keys().size() - 1) + "!";
                        //向客户端发送消息
                        socket.write(ByteBuffer.wrap(message.getBytes()));
                        InetSocketAddress address = (InetSocketAddress) socket.getRemoteAddress();
                        //输出客户端地址
                        log.info(ca.getTime() + "\t" + address.getHostString() +
                                ":" + address.getPort() + "\t");
                        log.info("客户端已连接");
                        log.info(LINE);
                    }

                    if (key.isReadable()) {
                        SocketChannel socket = (SocketChannel) key.channel();
                        InetSocketAddress address = (InetSocketAddress) socket.getRemoteAddress();
                        log.info(ca.getTime() + "\t" + address.getHostString() +
                                ":" + address.getPort() + "\t");
                        ByteBuffer bf = ByteBuffer.allocate(1024 * 4);
                        int len = 0;
                        byte[] res = new byte[1024 * 4];
                        //捕获异常，因为在客户端关闭后会发送FIN报文，会触发read事件，但连接已关闭,此时read()会产生异常
                        while ((len = socket.read(bf)) != 0) {
                            bf.flip();
                            bf.get(res, 0, len);
                            log.info(new String(res, 0, len));
                            bf.clear();
                        }
                        log.info(LINE);

                    }
                }
                flag++;
            }
        } catch (IOException e) {
            log.error(e.toString());
            log.info("服务器错误，服务器停止");
            log.info(LINE);
            return false;
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return true;
    }
}
