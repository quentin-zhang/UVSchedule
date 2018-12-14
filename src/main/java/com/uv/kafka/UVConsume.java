package com.uv.kafka;

import com.uv.services.ForeverService;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
@Configuration
public class UVConsume {
    @KafkaListener(topics = "uvsql", groupId = "foo")
    public void listen(String message) {
        System.out.println("sql : " + message);
        ForeverService.insertDirect(message);
    }
}
