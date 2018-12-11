package com.uv.kafka;

import com.uv.services.MSSQLService;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
@Configuration
public class UVConsume {

    @KafkaListener(topics = "uvsql", groupId = "foo")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
        MSSQLService service = new MSSQLService();
        service.insertDirect(message);
    }
}
