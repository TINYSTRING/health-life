package com.stringtinyst.healthlife.utils;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

@Component
public class UserChatSessionManager {

    private final Map<String, ChatMemory> userSessions = new ConcurrentHashMap<>();

    public String createNewSession() {
        String sessionId = UUID.randomUUID().toString();
        userSessions.put(sessionId, new InMemoryChatMemory());
        return sessionId;
    }

    public ChatMemory getChatMemory(String sessionId) {
        return userSessions.computeIfAbsent(sessionId, k -> new InMemoryChatMemory());
    }
}
