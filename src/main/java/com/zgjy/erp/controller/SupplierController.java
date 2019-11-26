package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgjy.erp.bean.Supplier;
import com.zgjy.erp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    //查询所有供应商
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Supplier> queryAll(Integer type){
        return supplierService.selectList(new EntityWrapper<Supplier>().eq("type",type));
    }
}

