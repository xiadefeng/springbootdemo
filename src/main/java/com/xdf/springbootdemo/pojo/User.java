package com.xdf.springbootdemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = true, length = 200)
    private String name;
    @Column(name = "age", nullable = true, length = 4)
    private Integer age;
}
