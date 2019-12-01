package com.zgjy.erp.service.impl;

import com.zgjy.erp.bean.Menu;
import com.zgjy.erp.mapper.MenuMapper;
import com.zgjy.erp.service.MenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public Set<String> queryPrivilegesByUsername(String username) {
        return menuMapper.queryPrivilegesByUsername(username);
    }
}
