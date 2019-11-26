package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.StoreoperVo;
import com.zgjy.erp.service.StoreoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/storeoper")
public class StoreoperController {
    @Autowired
    StoreoperService service;

    @RequestMapping("/queryByPager")
    @ResponseBody
    public Map queryByPager(@RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "5") Integer pageSize, StoreoperVo sv) {
        System.out.println("---");
        Page page = new Page(pageNumber, pageSize);
        List<StoreoperVo> lists = service.queryStoreoper(page, sv);
        Map map = new HashMap();
        map.put("rows", lists);
        map.put("total", page.getTotal());
        return map;
    }
}

