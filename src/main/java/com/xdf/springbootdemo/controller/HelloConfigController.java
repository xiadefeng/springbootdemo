package com.xdf.springbootdemo.controller;

import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/11
 */
@RestController
public class HelloConfigController {
    @Value("${officn_ip}")
    private String offcn_ip;

    @Value("${officn_port}")
    private String offcn_port;

    @GetMapping("/getvalue")
    public String getValue() {
        return "ip:"+offcn_ip+" port:"+offcn_port;
    }

}

