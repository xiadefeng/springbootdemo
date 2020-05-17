package com.xdf.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = true,length = 20)
    private String name;

    @Column(name = "age",nullable = true,length = 4)
    private int age;

    @OneToMany(mappedBy = "personId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Dog> dogs;
}
