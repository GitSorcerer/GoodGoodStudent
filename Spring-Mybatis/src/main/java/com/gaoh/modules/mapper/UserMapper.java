package com.gaoh.modules.mapper;

import com.gaoh.modules.entity.UserEntity;

import java.util.List;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/7 15:48
 * @Version: 1.0
 */
public interface UserMapper {
    List<UserEntity> select();

    void insert(UserEntity userEntity);
}
