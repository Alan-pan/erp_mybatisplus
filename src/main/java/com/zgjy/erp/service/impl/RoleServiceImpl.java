package com.zgjy.erp.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zgjy.erp.bean.EmpRole;
import com.zgjy.erp.bean.Role;
import com.zgjy.erp.bean.TreeNode;
import com.zgjy.erp.mapper.EmpRoleMapper;
import com.zgjy.erp.mapper.RoleMapper;
import com.zgjy.erp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    EmpRoleMapper empRoleMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<TreeNode> queryRolesByEid(int eid) {
        //查询出该id所有角色
        List<EmpRole> empRoles = empRoleMapper.selectList(new EntityWrapper<EmpRole>().eq("eid", eid));
        //查询所有角色
        List<Role> role = roleMapper.selectList(null);
        //创建返回值
        List<TreeNode> list = new ArrayList<>();

        for (Role r : role) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(r.getRid());
            treeNode.setName(r.getName());
            for (EmpRole er : empRoles) {
                if (er.getRid() == r.getRid()) {
                    treeNode.setChecked(true);
                    break;
                }
            }
            list.add(treeNode);
        }
        return list;
    }

}
