package com.uv.kafka;

import com.uv.services.MSSQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
@Configuration
public class UVConsume {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @KafkaListener(topics = "uvsql", groupId = "foo")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
        try
        {
            MSSQLService service = new MSSQLService();
            service.insertDirect(message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }
}
