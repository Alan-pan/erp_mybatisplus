package com.zgjy.erp.mapper;

import com.zgjy.erp.bean.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface RoleMapper extends BaseMapper<Role> {

    Set<String> queryRolesByUsername(String username);
}
