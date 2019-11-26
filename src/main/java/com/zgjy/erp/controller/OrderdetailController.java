package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Orderdetail;
import com.zgjy.erp.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderdetailController {
    @Autowired
    OrderdetailService odService;

    @RequestMapping("/queryOrderDetail")
    @ResponseBody
    public Map queryAll(@RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "5") Integer pageSize, Integer oid) {
        Page<Orderdetail> page = new Page<>(pageNumber,pageSize);
        Page<Orderdetail> res = odService.selectPage(page, new EntityWrapper<Orderdetail>().eq("oid", oid));
        Map map=new HashMap<>();
        map.put("rows",res.getRecords());
        map.put("total",res.getTotal());
        return map;
    }
}

