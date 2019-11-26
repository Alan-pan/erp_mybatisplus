package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Emp;
import com.zgjy.erp.bean.Menu;
import com.zgjy.erp.service.EmpService;
import com.zgjy.erp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    MenuService menuService;

    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "5") int pageSize, Emp emp) {
        //有问题---
        //分页条件查询eid ename
        Wrapper<Emp> wrapper = new EntityWrapper<Emp>();
        if(!StringUtils.isEmpty(emp.getEid())){
            //默认name所有匹配
            wrapper.eq("eid", emp.getEid()).and().like("name", "%" + emp.getName() + "%");
        }else if(!StringUtils.isEmpty(emp.getName())){
            wrapper.like("name", "%" + emp.getName() + "%");
        }
        Page<Emp> page = new Page<Emp>(pageNumber, pageSize);
        Page<Emp> pages = empService.selectPage(page,wrapper);
        int total = (int) page.getTotal();
        List<Emp> lists = pages.getRecords();
        Map map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", lists);
        return map;
    }

    @RequestMapping("/login")
    public ModelAndView login(Emp emp, HttpSession session) {
        //重定向页面需要写全路径以本项目开始路径
        if (empService.login(emp)) {
            ModelAndView mv = new ModelAndView("main");
            //设置菜单
            List<Menu> menus = menuService.selectList(null);
            System.out.println(menus);

            mv.addObject("menus",menus);
            session.setAttribute("emp",emp);
            return mv;
        } else {
            //登录失败重定向页面
            RedirectAttributes redirect=new RedirectAttributesModelMap();
            redirect.addAttribute("用户名或密码错误");
            return new ModelAndView("redirect:/static/login.html");
        }
    }

}

