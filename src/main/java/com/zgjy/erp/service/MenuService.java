package com.zgjy.erp.service;

import com.zgjy.erp.bean.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface MenuService extends IService<Menu> {

    Set<String> queryPrivilegesByUsername(String username);
}
