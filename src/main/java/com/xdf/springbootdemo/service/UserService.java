package com.xdf.springbootdemo.service;

import com.xdf.springbootdemo.pojo.User;

import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
//用户数据操作业务接口
public interface UserService {
    //获取全部用户数据
    public List<User> getUserList();
    //新增用户数据
    public void createUser(User user);
    //获取指定id用户信息
    public User getUser(Long id);
    //更新指定id用户信息
    public void updateUser(Long id,User user);
    //删除指定id用户
    public void deleteUser(Long id);
}
