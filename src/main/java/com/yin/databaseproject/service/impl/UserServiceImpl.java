package com.yin.databaseproject.service.impl;

import com.yin.databaseproject.dao.datasql.ItemMapper;
import com.yin.databaseproject.dao.pingyougou.UserMapper;
import com.yin.databaseproject.service.UserService;
import com.yin.databaseproject.vo.ItemVO;
import com.yin.databaseproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yin
 * @Date 2019/9/10 21:39
 * @Method
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<UserVO> getUsers() {
        return userMapper.findUser();
    }

    @Override
    public List<ItemVO> getItems() {
        return itemMapper.findItems();
    }
}
