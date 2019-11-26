package com.zgjy.erp.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Storeoper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zgjy.erp.bean.StoreoperVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface StoreoperMapper extends BaseMapper<Storeoper> {
    List<StoreoperVo> queryStoreoper(Page page, StoreoperVo sv);
}
