package com.gaoh.modules.controller;

import lombok.extern.slf4j.Slf4j;
import org.gaoh.model.Student;
import com.gaoh.modules.entity.UserEntity;
import com.gaoh.modules.service.UserService;
import com.gaoh.modules.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/7 15:45
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private Student student;


    @Autowired
    private UserService userService;


    @GetMapping("/select")
    @Transactional
    public Result<?> select() {
//        userService.selectList();
        List<UserEntity> select = userService.selectList();
       log.debug("{}",student);
        return Result.ok(select);
    }

    @GetMapping("/insert")
    @Transactional
    public Result<?> insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassWord(new Random().nextInt(1000) + "");
        userEntity.setRealName(new Random().nextInt(1000) + "");
        userEntity.setUserName(new Random().nextInt(1000) + "");
        userService.insert(userEntity);
        Integer i = 1 / 0;
        return Result.ok();
    }


}
