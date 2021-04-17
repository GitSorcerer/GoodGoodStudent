package com.gaoh.modules.service.impl;

import com.gaoh.modules.entity.UserEntity;
import com.gaoh.modules.mapper.UserMapper;
import com.gaoh.modules.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/7 15:46
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public List<UserEntity> selectList() {
        return userMapper.select();
    }

    @Override
    public void insert(UserEntity userEntity) {
        userMapper.insert(userEntity);
    }
}
