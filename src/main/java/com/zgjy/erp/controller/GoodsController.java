package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Emp;
import com.zgjy.erp.bean.Goods;
import com.zgjy.erp.bean.GoodsCategory;
import com.zgjy.erp.service.GoodsCategoryService;
import com.zgjy.erp.service.GoodsService;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsCategoryService gcService;
    @Autowired
    GoodsService gService;

    //分页条件查询
    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "5") Integer pageSize, Integer gid, Integer gcid) {
        List<Map<String, Object>> lm = new ArrayList<>();
        Map map = new HashMap();
        //编号查询
        if (!StringUtils.isEmpty(gid)) {
            Map<String, Object> good = gService.selectMap(new EntityWrapper<Goods>().eq("gid", gid));
            //根据good分类返回条件  分类未选中 或者 分类判定正确
            if (StringUtils.isEmpty(gcid) || good.get("gcid").equals(gcid)) {
                Map<String, Object> gc = gcService.selectMap(new EntityWrapper<GoodsCategory>().eq("gcid", gcid));
                //存入gcid...
                good.put("gcname", gc.get("name"));
                good.put("gcid", gc.get("gcid"));
                lm.add(good);
                map.put("rows", lm);//必须使用List<Map 存放在rows里面
                map.put("total", 1);
                return map;
            } else {
                return null;
            }
            //分类不为空 ||分类为空
        } else {
            //开启分页查询
            Page<Goods> page = new Page<Goods>(pageNumber, pageSize);
            Page<Map<String, Object>> pages;
            //分类为空
            if (StringUtils.isEmpty(gcid)) {
                pages = gService.selectMapsPage(page, null);
            } else {//分类不为空
                pages = gService.selectMapsPage(page, new EntityWrapper<Goods>().eq("gcid", gcid));
            }
            //查询所有分类并添加到map中
            List<GoodsCategory> gcs = gcService.selectList(null);
            List<Map<String, Object>> goods = pages.getRecords();
            for (Map good : goods) {
                for (GoodsCategory gc : gcs) {
                    if (good.get("gcid").equals(gc.getGcid())) {
                        good.put("gcname", gc.getName());
                        break;
                    }
                }
            }

            map.put("rows", goods);
            map.put("total", pages.getTotal());
        }
        return map;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Goods> queryAll(){
        return gService.selectList(null);
    }
}

