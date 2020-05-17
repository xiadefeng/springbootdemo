package com.xdf.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/11
 */
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "testuser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestUser {
    private String name;
    private String password;
    private String birthday;
}
