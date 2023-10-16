package com.example.FootballHuB.controller.Stompcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.websocket.server.ServerEndpoint;
import java.net.Socket;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StompController extends Socket {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/send")
    @SendTo
    public void sendMsg(@Payload Map<String,Object> data){
        simpMessagingTemplate.convertAndSend("/topic/1",data);
    }

}