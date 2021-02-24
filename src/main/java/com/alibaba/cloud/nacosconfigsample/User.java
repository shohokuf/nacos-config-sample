package com.alibaba.cloud.nacosconfigsample;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author sunchuanfu
 * @date 2021/2/24 15:30
 */
@RefreshScope
@Data
@ConfigurationProperties(prefix = "user")
public class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
