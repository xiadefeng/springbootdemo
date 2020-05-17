package com.xdf.springbootdemo.controller;

import com.xdf.springbootdemo.pojo.User;
import com.xdf.springbootdemo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author:xiadefeng
 * @email:310484874@qq.com
 * @date:2020/5/12
 */
@Controller
@RequestMapping("/manageruser")
public class UserController {
    @Autowired
  private   UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/")
    public String getUserList(Model model){
        List<User> list = userService.getUserList();
        model.addAttribute("page", list);
        return "user/list";
    }
    /***
     * 跳转到新增用户界面
     * @param user
     * @return
     */
    @RequestMapping("/toAdd")
    public String toadd(User user){
        return "user/userAdd";//跳转到userAdd.html
    }
    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加用户信息",notes = "添加用户信息")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    public String creatUser(User user){
        userService.createUser(user);
        return "redirect:/manageruser/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id")Long id){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user/userEdit"; //跳转到userEdit.html页面
    }

    @RequestMapping("/edit")
    public String edit(User user){
        userService.updateUser(user.getId(), user);
        return "redirect:/manageruser/";//获取列表数据并显示
    }
    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/manageruser/";

    }
}
