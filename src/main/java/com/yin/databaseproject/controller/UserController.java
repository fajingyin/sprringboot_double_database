package com.yin.databaseproject.controller;

import com.yin.databaseproject.service.UserService;
import com.yin.databaseproject.vo.ItemVO;
import com.yin.databaseproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yin
 * @Date 2019/9/10 21:38
 * @Method
 */
@RestController
@RequestMapping("/database/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUser")
    public List<UserVO> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getItem")
    public List<ItemVO> getItems(){
        return userService.getItems();
    }
}
