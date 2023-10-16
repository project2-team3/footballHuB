package com.example.FootballHuB.Interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Component
public class WebSocketInterceptor extends ChannelInterceptorAdapter {
    Set<String> sessionSet = new HashSet<>();

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        String simpMessageType = String.valueOf(message.getHeaders().get("simpMessageType"));

        if(StringUtils.equals(simpMessageType, "CONNECT")) {
            String simpSessionId = String.valueOf(message.getHeaders().get("simpSessionId"));
            sessionSet.add(simpSessionId);
        } else if(StringUtils.equals(simpMessageType, "DISCONNECT")) {
            String simpSessionId = String.valueOf(message.getHeaders().get("simpSessionId"));
            sessionSet.remove(simpSessionId);
        }

        int uniqueJoinSessionCount = sessionSet.size();
        System.out.println("동시 접속자 수 " + uniqueJoinSessionCount);

        return super.preSend(message, channel);
    }

    public int getUniqueJoinSessionCount() {
        return sessionSet.size();
    }
}
