package com.zgjy.erp.controller;


import com.zgjy.erp.bean.Menu;
import com.zgjy.erp.bean.TreeNode;
import com.zgjy.erp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/queryMenus")
    @ResponseBody
    public List<TreeNode> queryMenus(){
        List<TreeNode> treeNodeList=new ArrayList<>();
        List<Menu> menus = menuService.selectList(null);
        for(Menu m:menus){
            TreeNode node=new TreeNode();
            node.setId(m.getMid());
            node.setpId(m.getPid());
            //查询出所有父节点的菜单信息

            node.setName(m.getName());
            node.setUrl(m.getUrl());

            treeNodeList.add(node);
        }
        return treeNodeList;
    }

    @RequestMapping("/updateMenus")
    @ResponseBody
    public Boolean updateMenus(Menu menu){
        return menuService.insertOrUpdate(menu);
    }

}

