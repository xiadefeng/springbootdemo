package com.xdf.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/11
 */
@Controller
public class WebJarsDemoController {
    @GetMapping("/")
    public String index() {
        return "demo.html";
    }
}
