package com.xdf.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/17
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long personId;

}
