package com.yuan.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YuanEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuanEurekaApplication.class, args);
    }

}
