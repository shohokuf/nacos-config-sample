package com.alibaba.cloud.nacosconfigsample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class NacosConfigSampleApplication {

    @Value("${user.name}")
    private String userName;
    @Value("${user.age}")
    private int userAge;

    @PostConstruct
    public void init() {
        System.out.printf("[init] user name : %s , age : %d%n", userName, userAge);
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigSampleApplication.class, args);
    }

}
