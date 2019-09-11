package com.yin.databaseproject.service;

import com.yin.databaseproject.vo.ItemVO;
import com.yin.databaseproject.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yin
 * @Date 2019/9/10 21:38
 * @Method
 */

public interface UserService {
    List<UserVO> getUsers();

    List<ItemVO> getItems();
}
