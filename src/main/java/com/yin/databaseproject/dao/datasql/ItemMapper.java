package com.yin.databaseproject.dao.datasql;

import com.yin.databaseproject.vo.ItemVO;
import com.yin.databaseproject.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yin
 * @Date 2019/9/11 23:13
 * @Method
 */
@Mapper
public interface ItemMapper {
    List<ItemVO> findItems();

    List<OrderVO> findOrdersa();

}
