package com.gaoh.controller;

import com.gaoh.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/26 11:29
 * @Version: 1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        System.out.println(helloService);
        return "hello...";
    }
}
