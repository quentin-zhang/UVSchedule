package com.uv.schedule;

import com.uv.other.SingleBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.uv"})
public class UvscheduleApplication {

    private SingleBootstrap singleBootstrap;

    @Autowired
    public UvscheduleApplication(SingleBootstrap mySingleBootstrap)
    {
        this.singleBootstrap = mySingleBootstrap;
        singleBootstrap.execute();
    }


    public static void main(String[] args) {
        SpringApplication.run(UvscheduleApplication.class, args);
    }

}
