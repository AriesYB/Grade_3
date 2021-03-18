package com.bosssoft.hr.train.j2se.basic.example.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author HetFrame
 * @Description 客户端
 * @date 2020/5/31 21:57
 */
@Slf4j
public class ClientSocket implements Starter {
    private static final int PORT = 6789;
    @Override
    public boolean start() {
        SocketChannel socket = null;
        try {
            //设置ip以及端口号
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", PORT);
            socket = SocketChannel.open(inetSocketAddress);
            //非阻塞
            socket.configureBlocking(false);
            //设置buffer大小
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            // 发送数据
            buffer.put("client send : hello server".getBytes());
            buffer.flip();
            socket.write(buffer);
            buffer.clear();
            //接收server数据
            int len = 0;
            while ((len = socket.read(buffer)) != -1) {
                buffer.flip();
                String context = new String(buffer.array(), 0, len);
                log.info(context);
                buffer.clear();
            }
            return true;
        } catch (IOException e) {
            log.info("客户端错误！");
            return false;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }
}
