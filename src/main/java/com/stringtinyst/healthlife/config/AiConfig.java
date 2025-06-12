package com.stringtinyst.healthlife.config;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.stringtinyst.healthlife.utils.UserChatSessionManager;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    // 移除 @Autowired 注解，直接创建 ChatMemory 实例
    private final ChatMemory chatMemory = new InMemoryChatMemory();

    @Bean
    public ChatMemory chatMemory() {
        return new InMemoryChatMemory(); // 创建 ChatMemory Bean
    }
//    @Bean
//    public ChatClient chatClient(ChatClient.Builder builder){
//        return builder.defaultSystem("你是一个经验丰富的健康生活专家，你精通各种饮食与运动知识，能迅速对身体的各项数据进行分析。").build();
//    }
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultSystem("你是经验丰富的健康生活专家，能提供饮食与运动建议")
                .defaultAdvisors(new MessageChatMemoryAdvisor(chatMemory)) // 使用内部实例
                .build();
    }
}

