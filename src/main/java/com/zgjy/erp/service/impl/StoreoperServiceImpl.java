package com.zgjy.erp.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Storeoper;
import com.zgjy.erp.bean.StoreoperVo;
import com.zgjy.erp.mapper.StoreMapper;
import com.zgjy.erp.mapper.StoreoperMapper;
import com.zgjy.erp.service.StoreoperService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class StoreoperServiceImpl extends ServiceImpl<StoreoperMapper, Storeoper> implements StoreoperService {
    @Autowired
    StoreoperMapper mapper;

    @Override
    public List<StoreoperVo> queryStoreoper(Page page, StoreoperVo sv) {
        return mapper.queryStoreoper(page,sv);
    }
}
