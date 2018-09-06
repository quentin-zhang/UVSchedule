package com.uv.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.uv"})
public class UvscheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UvscheduleApplication.class, args);
    }

}
