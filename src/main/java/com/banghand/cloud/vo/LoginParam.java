package com.banghand.cloud.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author sunyz
 * @desc 登录
 * @create 2019-05-27 上午11:05
 */
@Setter
@Getter
public class LoginParam implements Serializable {

    private String userName;

    private String  password;
}
