package com.yin.databaseproject.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yin
 * @Date 2019/9/10 21:41
 * @Method
 */
@Data
public class UserVO implements Serializable {
    private String id;
    private String username;
    private String password;
    private String phone;
}
