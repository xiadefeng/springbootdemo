package com.xdf.springbootdemo.dao;

import com.xdf.springbootdemo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/17
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    User findByNameAndAge(String name,Integer age);
}
