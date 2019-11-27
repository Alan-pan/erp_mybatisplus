package com.zgjy.erp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.StoreWarn;

import java.util.List;

public interface StoreWarnMapper extends BaseMapper<StoreWarn> {
    List<StoreWarn> queryStoreWarn(Page page);
}