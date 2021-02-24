package com.alibaba.cloud.nacosconfigsample;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@EnableConfigurationProperties(User.class)// 激活@ConfigurationProperties Bean User
@SpringBootApplication
@Configuration
@RestController
@RefreshScope
public class NacosConfigSampleApplication {

    @Value("${user.name}")
    private String userName;
    @Value("${user.age}")
    private int userAge;

    private NacosConfigManager nacosConfigManager;

    @Autowired
    private User user;

    @PostConstruct
    public void init() {
        System.out.printf("[init] user name : %s , age : %d%n", userName, userAge);
    }

    @PreDestroy
    public void destroy() { System.out.printf("[destroy] user name : %s , age : %d%n", userName, userAge); }

    @RequestMapping("/user")
    public String user() {
        return String.format("[HTTP] user name : %s , age : %d", userName, userAge);
    }

    @RequestMapping("/user2")
    public String user2() {
        return "[HTTP]" + user;
    }

    /*@Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "nacos-config-sample.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("[Listener] " + configInfo);
                }
            });
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigSampleApplication.class, args);
    }

}
