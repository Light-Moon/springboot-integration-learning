package com.imooc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.pojo.IMoocJsonResult;
import com.imooc.pojo.User;

//ctrl+shift+o 快捷键可以将未用的依赖包全部删除
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc(null);
        user.setName("imooc2");
        user.setPassword("imooc2");
        return user;
    }

    @RequestMapping("/getJson")
    @ResponseBody
    public IMoocJsonResult getUserJson() {
        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc(null);
        user.setName("imooc");
        user.setPassword("imooc");
        return IMoocJsonResult.ok(user);
    }
}
