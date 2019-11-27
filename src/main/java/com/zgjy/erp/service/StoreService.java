package com.zgjy.erp.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgjy.erp.bean.Store;
import com.baomidou.mybatisplus.service.IService;
import com.zgjy.erp.bean.StoreWarn;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
public interface StoreService extends IService<Store> {

    List<StoreWarn> queryStoreWarn(Page page);

    public Integer sendEmail();
}
