package com.yuan.bookmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 客户端注册服务发现
@EnableDiscoveryClient
public class YuanOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuanOrderApplication.class, args);
    }

}
