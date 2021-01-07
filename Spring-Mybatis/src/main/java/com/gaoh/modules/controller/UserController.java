package com.gaoh.modules.controller;

import com.gaoh.modules.entity.UserEntity;
import com.gaoh.modules.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class UserController {
    @Resource
    private UserMapper userMapper;


    /**
     * 不添加  @Transactional
     *
     * 2021-01-07 16:09:20.295 DEBUG 19992 --- [io-6666-exec-10] org.mybatis.spring.SqlSessionUtils       : Creating a new SqlSession
     * 2021-01-07 16:09:20.295 DEBUG 19992 --- [io-6666-exec-10] org.mybatis.spring.SqlSessionUtils       : SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@10a291b] was not registered for synchronization because synchronization is not active
     * 2021-01-07 16:09:20.296 DEBUG 19992 --- [io-6666-exec-10] o.m.s.t.SpringManagedTransaction         : JDBC Connection [HikariProxyConnection@59496065 wrapping com.mysql.cj.jdbc.ConnectionImpl@b9f3dcc] will not be managed by Spring
     * 2021-01-07 16:09:20.297 DEBUG 19992 --- [io-6666-exec-10] c.gaoh.modules.mapper.UserMapper.select  : ==>  Preparing: select * from user
     * 2021-01-07 16:09:20.298 DEBUG 19992 --- [io-6666-exec-10] c.gaoh.modules.mapper.UserMapper.select  : ==> Parameters:
     * 2021-01-07 16:09:20.304 DEBUG 19992 --- [io-6666-exec-10] c.gaoh.modules.mapper.UserMapper.select  : <==      Total: 10
     *
     *
     * 2021-01-07 16:11:05.315 DEBUG 9576 --- [nio-6666-exec-4] org.mybatis.spring.SqlSessionUtils       : Creating a new SqlSession
     * 2021-01-07 16:11:05.315 DEBUG 9576 --- [nio-6666-exec-4] org.mybatis.spring.SqlSessionUtils       : Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@21a6d8fd]
     * 2021-01-07 16:11:05.315 DEBUG 9576 --- [nio-6666-exec-4] o.m.s.t.SpringManagedTransaction         : JDBC Connection [HikariProxyConnection@727626637 wrapping com.mysql.cj.jdbc.ConnectionImpl@1003975c] will be managed by Spring
     * 2021-01-07 16:11:05.316 DEBUG 9576 --- [nio-6666-exec-4] c.gaoh.modules.mapper.UserMapper.select  : ==>  Preparing: select * from user
     * 2021-01-07 16:11:05.316 DEBUG 9576 --- [nio-6666-exec-4] c.gaoh.modules.mapper.UserMapper.select  : ==> Parameters:
     * 2021-01-07 16:11:05.329 DEBUG 9576 --- [nio-6666-exec-4] c.gaoh.modules.mapper.UserMapper.select  : <==      Total: 10
     * 2021-01-07 16:11:05.330 DEBUG 9576 --- [nio-6666-exec-4] org.mybatis.spring.SqlSessionUtils       : Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@21a6d8fd]
     * 2021-01-07 16:11:05.333 DEBUG 9576 --- [nio-6666-exec-4] org.mybatis.spring.SqlSessionUtils       : Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@21a6d8fd]
     * 2021-01-07 16:11:05.334 DEBUG 9576 --- [nio-6666-exec-4] org.mybatis.spring.SqlSessionUtils       : Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@21a6d8fd]
     * 2021-01-07 16:11:05.334 DEBUG 9576 --- [nio-6666-exec-4] org.mybatis.spring.SqlSessionUtils       : Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@21a6d8fd]
     */

    @GetMapping("/select")
    @Transactional
    public Object select() {
        List<UserEntity> select = userMapper.select();
        return select;
    }

    @GetMapping("/insert")
    public Object insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassWord(new Random().nextInt(1000) + "");
        userEntity.setRealName(new Random().nextInt(1000) + "");
        userEntity.setUserName(new Random().nextInt(1000) + "");
        userMapper.insert(userEntity);
        return "success";
    }



}
