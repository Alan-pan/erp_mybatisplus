package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.api.MailHelper;
import com.zgjy.erp.bean.Store;
import com.zgjy.erp.bean.StoreWarn;
import com.zgjy.erp.mapper.StoreWarnMapper;
import com.zgjy.erp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService sService;
    @Autowired
    StoreWarnMapper swMapper;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Store> queryAll() {
        return sService.selectList(null);
    }


    @RequestMapping("/queryStoreWarn")
    @ResponseBody
    public Map queryStoreWarn(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = new Page(pageNumber, pageSize);
        List<StoreWarn> lists = swMapper.queryStoreWarn(page);
        Map map = new HashMap();
        map.put("rows", lists);
        map.put("total", page.getTotal());
        return map;
    }
    @Autowired
    MailHelper mailHelper;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public int sendEmail() {
        return sService.sendEmail();
    }
}

