package com.yin.databaseproject.vo;

import java.io.Serializable;

/**
 * @author yin
 * @Date 2019/9/10 21:41
 * @Method
 */
public class UserVO implements Serializable {
    private String id;
    private String username;
    private String password;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
