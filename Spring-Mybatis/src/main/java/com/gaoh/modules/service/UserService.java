package com.gaoh.modules.service;

import com.gaoh.modules.entity.UserEntity;

import java.util.List;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/7 15:46
 * @Version: 1.0
 */
public interface UserService {
    List<UserEntity> selectList();

    void insert(UserEntity userEntity);
}
