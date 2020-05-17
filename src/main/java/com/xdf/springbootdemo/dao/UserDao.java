package com.xdf.springbootdemo.dao;

import com.xdf.springbootdemo.pojo.User;

import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
public interface UserDao {
    public void save(User user);

    public void update(User user);

    public void delete(Long id);

    public List<User> getAll();

    public User findOne(Long id);
}
