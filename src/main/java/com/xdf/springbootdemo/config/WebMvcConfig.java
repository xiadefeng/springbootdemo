package com.xdf.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/11
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //将所有D:\\springboot\\pic\\ 访问都映射到/myPic/** 路径下
       // registry.addResourceHandler("/myPic/**").addResourceLocations("file:D:\\springboot\\pic\\");
        //配置映射关系
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(true);//加入resourceChain属性，不然还是去除了版本时路径找不到的
    }
}
