package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Order;
import com.zgjy.erp.bean.Orderdetail;
import com.zgjy.erp.bean.Storedetail;
import com.zgjy.erp.bean.Storeoper;
import com.zgjy.erp.mapper.OrderMapper;
import com.zgjy.erp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderdetailService odService;
    @Autowired
    StoredetailService sdService;
    @Autowired
    OrderMapper orderMapper;
    @RequestMapping("/trend")
    @ResponseBody
    public List trend(String year){
        List<Map> res=new ArrayList<>();
        List<Map> lines = orderMapper.querySaleByPerMonth(year);
        for(int i=1;i<=12;i++){
            boolean flag=false;//默认不存在
            for(Map map:lines){
                if(map.get("month").equals(i)){
                    flag=true;
                    res.add(map);
                    break;
                }
            }
            if(!flag){
                Map map=new HashMap();
                map.put("month",i);
                map.put("y",0);
                res.add(map);
            }
        }
        return res;
    }

    @RequestMapping("/orderReport")
    @ResponseBody
    public Map orderReport(String d,String d2){
        if(!StringUtils.isEmpty(d))
            d=d.substring(0,10);
        if(!StringUtils.isEmpty(d2))
            d2=d2.substring(0,10);

        List<HashMap> list = orderMapper.queryOrder(d, d2);
        System.out.println(list);
        Map map=new HashMap();
        map.put("rows",list);
        map.put("total",list.size());
        return map;
    }

    //    url: "../order/add",
//    data:{"sid":sid,"supplierName":supplierName,"json":json},
    @RequestMapping("/add")
    @ResponseBody
    public Integer add(Integer sid, String supplierName, String json) {
        return orderService.add(sid, supplierName, json);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public Map queryAll(@RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Order> res = orderService.selectPage(new Page<Order>(pageNumber, pageSize), null);
        Map map = new HashMap<>();
        map.put("rows", res.getRecords());
        map.put("total", res.getTotal());
        return map;
    }


    @RequestMapping("/queryOrderByoid")
    @ResponseBody
    public Order queryOrderByoid(Integer oid) {
        return orderService.selectById(oid);
    }


    @RequestMapping("/checkOrcomfire")
    @ResponseBody
    public Boolean checkOrcomfire(Integer oid, Integer state) {
        //获取原来的order
        Order order = orderService.selectById(oid);
        if (order.getState()== 0) {//审核
            order.setChecker(2);
            order.setCheckerName("中鱼");
            order.setChecktime(new Date());
            order.setState(1);//->审核状态
        } else if (order.getState() == 1) {//确认
            order.setEnder(3);
            order.setStarttime(new Date());
            order.setStarterName("确认人");
            order.setState(2);//->确认状态

            //更新对应的订单详情是确认状态
            List<Orderdetail> ods = odService.selectList(new EntityWrapper<Orderdetail>().eq("oid", oid));
            for (Orderdetail od : ods) {
                od.setState("2");//订单详情确认状态
            }
            odService.updateBatchById(ods);
        }
        return orderService.updateById(order);
    }

    @Autowired
    StoreoperService storeoperService;

    @RequestMapping("/instore")
    @ResponseBody
    // data:{"oid":id,"odid":odid,  "gid":gid,"gname":gname,"num":num,"sid":sid,"sname":name},
    public Boolean instore(int oid, int odid, Storedetail sd) {
        boolean flag = true;
        //更新订单详情表
        Orderdetail orderDetail = odService.selectById(odid);
        orderDetail.setEnder(3);
        orderDetail.setEndtime(new Date());
        orderDetail.setState("3");//入库
        orderDetail.setStoreid(sd.getSid());
        boolean res = odService.update(orderDetail,new EntityWrapper<Orderdetail>().eq("odid",odid));
        if (!res) {
            flag = false;
        }
        //更新订单表
        //查询当前订单下的所有订单详情,判断订单详情的状态是否都为入库的状态
        List<Orderdetail> ods = odService.selectList(new EntityWrapper<Orderdetail>().eq("oid",oid).eq("state",2));
        if (ods == null || ods.size() == 0) {
            Order order = orderService.selectById(oid);
            order.setEnder(3);
            order.setEnderName("入库员1");
            order.setEndtime(new Date());
            order.setState(3);//入库
            boolean b = orderService.updateById(order);
            if (!b) {
                flag = false;
            }
        }
        //添加或者更新仓库详情表
        //根据仓库编号与商品的编号查询数据
        List<Storedetail> sds = sdService.selectList(new EntityWrapper<Storedetail>().eq("gid", sd.getGid()).eq("sid", sd.getSid()));
        if(sds.size()!=0) {
            for (Storedetail storeDetail : sds) {
                storeDetail.setNum(storeDetail.getNum() + sd.getNum());
                storeDetail.setSname(sd.getSname());
                boolean i3 = sdService.insertOrUpdate(storeDetail);
                if (!i3) {
                    flag = false;
                }
            }
        }else{
            boolean i3 = sdService.insertOrUpdate(sd);
        }

        //添加仓库记录表
        Storeoper storeoper = new Storeoper();
        storeoper.setEmpid(3);
        storeoper.setGoodsid(sd.getGid());
        storeoper.setNum(sd.getNum());
        storeoper.setOpertime(new Date());
        storeoper.setStoreid(sd.getSid());
        storeoper.setType("3");
        boolean i5 = storeoperService.insert(storeoper);
        if (!i5) {
            flag = false;
        }
        if (flag) {
            return true;
        }
        return false;
    }

}

