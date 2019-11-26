package com.zgjy.erp.controller;


import com.zgjy.erp.bean.Store;
import com.zgjy.erp.service.StoreService;
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
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService sService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Store> queryAll(){
        return sService.selectList(null);
    }
}

