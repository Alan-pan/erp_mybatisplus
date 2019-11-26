package com.zgjy.erp.controller;


import com.zgjy.erp.bean.GoodsCategory;
import com.zgjy.erp.service.GoodsCategoryService;
import com.zgjy.erp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {
    @Autowired
    GoodsCategoryService gcService;
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<GoodsCategory> queryAll(){
        return gcService.selectList(null);
    }
}

