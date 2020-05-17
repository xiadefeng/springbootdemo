package com.xdf.springbootdemo.controller;

import com.xdf.springbootdemo.pojo.TestUser;
import com.xdf.springbootdemo.pojo.UserBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/11
 */
@RestController
@EnableConfigurationProperties({UserBody.class, TestUser.class})
public class HelloControllerBean {
    @Resource
    UserBody userbody;

    @Autowired
    TestUser testUser;
    @GetMapping("/getUser")
    public String getUser(){
        return userbody.toString();
    }
    @GetMapping("/gettestuser")
    public String gettestUser() {
        return testUser.toString();
    }

}
