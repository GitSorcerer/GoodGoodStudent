package com.gaoh.modules.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: gaoh
 * @Date: 2021/1/7 15:43
 * @Version: 1.0
 */
@Data
public class UserEntity {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}
