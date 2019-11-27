package com.zgjy.erp.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Store;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zgjy.erp.bean.StoreWarn;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface StoreMapper extends BaseMapper<Store> {

    List<StoreWarn> queryStoreWarn(Page page);
}
