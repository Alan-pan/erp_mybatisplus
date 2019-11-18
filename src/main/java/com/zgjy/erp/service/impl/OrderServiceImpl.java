package com.zgjy.erp.service.impl;

import com.zgjy.erp.bean.Order;
import com.zgjy.erp.mapper.OrderMapper;
import com.zgjy.erp.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
