package com.zgjy.erp.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zgjy.erp.bean.Order;
import com.zgjy.erp.bean.Orderdetail;
import com.zgjy.erp.mapper.OrderMapper;
import com.zgjy.erp.mapper.OrderdetailMapper;
import com.zgjy.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderdetailMapper odMappper;

    public Integer add(Integer sid, String supplierName, String json) {
        /*public final static int NO_CHECK=0; 未审批
        public final static int CHECKED=1;     审批
        public final static int COMFIRE=2;      确认

        public final static int INSTORE=3;      未入库
        public final static int OUTSTORE=4;     已入库
        */
        //保存订单
        Order order=new Order();
        order.setCreater(1);//创建者
        order.setCreaterName("小鱼");//创建者姓名
        order.setCreatetime(new Date());//创建日期
        order.setState(0);//未审批状态

        order.setType("3");//未入库状态
        order.setSupplier(sid);//供应商id
        order.setSupplierName(supplierName);//供应商名
        //存入订单号 并返回 oid 直接有对应的方法
        Integer insert = orderMapper.insert(order);
        System.out.println("直接获取主键oid"+order.getOid());

        //然后再订单详情表添加订单
        List<Orderdetail> ods = JSON.parseArray(json, Orderdetail.class);

        //成功flag
        Integer flag=1;
        for(Orderdetail od:ods){
            od.setOid(order.getOid());
            Integer res = odMappper.insert(od);
            if(res!=1){
                flag=0;
            }

        }

        return flag;
    }
}
