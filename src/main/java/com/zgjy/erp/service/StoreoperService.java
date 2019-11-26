package com.zgjy.erp.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Storeoper;
import com.baomidou.mybatisplus.service.IService;
import com.zgjy.erp.bean.StoreoperVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface StoreoperService extends IService<Storeoper> {
    List<StoreoperVo> queryStoreoper(Page page, StoreoperVo sv);
}
