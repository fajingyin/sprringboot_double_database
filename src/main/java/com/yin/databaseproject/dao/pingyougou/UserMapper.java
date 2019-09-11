package com.yin.databaseproject.dao.pingyougou;

import com.yin.databaseproject.vo.UserVO;

import java.util.List;

/**
 * @author yin
 * @Date 2019/9/10 21:49
 * @Method
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper  {

    List<UserVO> findUser();
}
