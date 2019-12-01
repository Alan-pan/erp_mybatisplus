package com.zgjy.erp.mapper;

import com.zgjy.erp.bean.Menu;
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
public interface MenuMapper extends BaseMapper<Menu> {

    Set<String> queryPrivilegesByUsername(String username);
}
