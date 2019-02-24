package com.imooc.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.pojo.IMoocJsonResult;
import com.imooc.pojo.SysUser;
import com.imooc.service.UserService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public IMoocJsonResult saveUser() throws Exception {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc" + new Date());
        user.setNickname("imooc" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return IMoocJsonResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJsonResult updateUser() {

        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return IMoocJsonResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public IMoocJsonResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return IMoocJsonResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public IMoocJsonResult queryUserById(String userId) {

        return IMoocJsonResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public IMoocJsonResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);

        return IMoocJsonResult.ok(userList);
    }

}
