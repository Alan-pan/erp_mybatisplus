package com.zgjy.erp.service;

import com.zgjy.erp.bean.Role;
import com.baomidou.mybatisplus.service.IService;
import com.zgjy.erp.bean.TreeNode;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface RoleService extends IService<Role> {

    List<TreeNode> queryRolesByEid(int eid);

    Set<String> queryRolesByUsername(String username);
}
