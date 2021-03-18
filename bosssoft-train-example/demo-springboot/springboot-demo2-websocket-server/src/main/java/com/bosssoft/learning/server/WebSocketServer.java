package com.bosssoft.learning.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description server
 * @Date 2020/6/11 15:48
 * @Author HetFrame
 */

@Slf4j
@ServerEndpoint("/server")
@Component
public class WebSocketServer {

    private static Map<String, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        log.info("与客户端:" + session.getId() + "建立连接");
        clients.put(session.getId(), session);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("与客户端:" + session.getId() + "断开连接");
        clients.remove(session.getId());
    }

    @OnError
    public void onError(Throwable throwable) {
        log.error("发生错误!", throwable);
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("接收客户端消息:" + message);
        sendMessage("  回复消息："+message);
    }

    public void sendMessage(String message) {
        for (Session session : clients.values()) {
            session.getAsyncRemote().sendText("sessionID:"+session.getId()+message);
        }
    }

}
