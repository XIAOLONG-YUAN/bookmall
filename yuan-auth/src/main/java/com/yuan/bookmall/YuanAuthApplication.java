package com.yuan.bookmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class YuanAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuanAuthApplication.class, args);
    }

}
