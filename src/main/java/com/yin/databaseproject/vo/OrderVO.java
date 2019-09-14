package com.yin.databaseproject.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yin
 * @Date 2019/9/14 11:05
 * @Method
 */
@Data
public class OrderVO {
    private String orderId;
    private String numId;
    private UserVO user;
    private List<String> orderDetailId;
    private List<OrderDetail> orderDetail;
}
