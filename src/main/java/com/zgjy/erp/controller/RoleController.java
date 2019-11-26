package com.zgjy.erp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgjy.erp.bean.EmpRole;
import com.zgjy.erp.bean.TreeNode;
import com.zgjy.erp.service.EmpRoleService;
import com.zgjy.erp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    EmpRoleService empRoleService;
    @RequestMapping("/queryRolesByEid")
    @ResponseBody
    public List<TreeNode> queryRolesByEid(int eid){
        return roleService.queryRolesByEid(eid);
    }

    @RequestMapping("/addEmpRoles")
    @ResponseBody
    public Map queryRolesByEid(int eid,int[] rid){
        System.out.println(Arrays.toString(rid));
        //首先清空该eid所有角色
        empRoleService.delete(new EntityWrapper<EmpRole>().eq("eid",eid));
        //然后添加角色rid
        List<EmpRole> list=new ArrayList<>();
        for(int i=0;i<rid.length;i++){
            EmpRole er=new EmpRole();
            er.setEid(eid);
            er.setRid(rid[i]);
            list.add(er);//添加的是引用 如果引用内容修改 之前添加的内容同样修改
        }
        boolean b = empRoleService.insertBatch(list);

        Map map=new HashMap();
        if(b){
            map.put("status",1);
        }else{
            map.put("status",0);

        }
        return map;
    }
}

