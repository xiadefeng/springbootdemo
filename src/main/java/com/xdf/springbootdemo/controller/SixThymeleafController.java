package com.xdf.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/17
 */
@Controller
public class SixThymeleafController {
    @GetMapping("/six")
    public String indexPage(Model model) {
        return "index6";
    }
}
