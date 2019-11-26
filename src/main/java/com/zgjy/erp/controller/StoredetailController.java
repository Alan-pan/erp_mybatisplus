package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgjy.erp.bean.Storedetail;
import com.zgjy.erp.service.StoredetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/storedetail")
public class StoredetailController {
    @Autowired
    StoredetailService sdService;

    @ResponseBody
    @RequestMapping("/list")
    public Map list(Integer gid, Integer sid) {
        Map map = new HashMap();
        List<Storedetail> list=null;
        if (StringUtils.isEmpty(gid) && StringUtils.isEmpty(sid)) {
            list = sdService.selectList(null);
        }else{
            list = sdService.selectList(new EntityWrapper<Storedetail>().eq(!StringUtils.isEmpty(gid),"gid",gid).eq(!StringUtils.isEmpty(sid),"sid",sid));
        }
        map.put("rows", list);
        map.put("total", list.size());
        return map;
    }
}

