//package com.stringtinyst.healthlife.controller;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//@RestController
//public class ChatController {
//    @Autowired
//    private ChatClient chatClient;
//
//    @GetMapping(value = "/chat",produces = "text/html;charset=UTF-8")
//    public Flux<String> chat3(@RequestParam(value = "msg")
//                              String message){
//        return chatClient.prompt()
//                .user(message)
//                .stream()
//                .content();
//    }
//}
package com.stringtinyst.healthlife.controller;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.stringtinyst.healthlife.utils.JwtUtils;
import com.stringtinyst.healthlife.utils.UserChatSessionManager;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

//    private final DashScopeChatModel dashScopeChatModel;
//    private final UserChatSessionManager sessionManager;
//
//    public ChatController(DashScopeChatModel dashScopeChatModel, UserChatSessionManager sessionManager) {
//        this.dashScopeChatModel = dashScopeChatModel;
//        this.sessionManager = sessionManager;
//    }
    @Autowired
    private DashScopeChatModel dashScopeChatModel;
    @Autowired
    private UserChatSessionManager sessionManager;

    @GetMapping(produces = "text/html;charset=UTF-8")
    public Flux<String> chat(
            @RequestParam("msg") String message,
            @RequestHeader("token") String token) { // 强制要求传 token

        // 1. 解析 token 获取 userId
        String userId = extractUserIdFromToken(token);

        // 2. 获取该用户专属的记忆存储
        ChatMemory chatMemory = sessionManager.getChatMemory(userId);

        // 3. 构建 ChatClient
        ChatClient chatClient = ChatClient.builder(dashScopeChatModel)
                .defaultAdvisors(new MessageChatMemoryAdvisor(chatMemory))
                .build();

        // 4. 发起流式调用
        return chatClient.prompt()
                .user(message)
                .advisors(spec -> spec.param("conversation_id", userId).param("retrieve_size", 10))
                .stream()
                .content()
                .map(s -> s + "<br>");
    }

    /**
     * 从 token 中提取 userId
     */
    private String extractUserIdFromToken(String token) {
        try {
            Map<String, Object> claims = JwtUtils.parseJWT(token);
            Object userId = claims.get("userID"); // 根据你实际 payload 结构调整 key
            if (userId == null || userId.toString().isEmpty()) {
                throw new IllegalArgumentException("Token 中未包含 userID");
            }
            return userId.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("无效的 token 或 token 中无 userId");
        }
    }
}


