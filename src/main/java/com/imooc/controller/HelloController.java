package com.imooc.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.pojo.IMoocJsonResult;
import com.imooc.pojo.Resource;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Object hello() {
        return "hello springboot!";
    }

    @Autowired
    private Resource resource;

    @RequestMapping("/getResource")
    public IMoocJsonResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return IMoocJsonResult.ok(bean);
    }
}
