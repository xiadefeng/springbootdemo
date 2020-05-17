package com.xdf.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/11
 */
@ConfigurationProperties(prefix = "userbody")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBody {
    private String name;
    private String password;
    private String birthday;
    private String mobile;
    private String address;
}
