package com.zgjy.erp.service;

import com.zgjy.erp.bean.Order;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface OrderService extends IService<Order> {

    Integer add(Integer sid, String supplierName, String json);
}
