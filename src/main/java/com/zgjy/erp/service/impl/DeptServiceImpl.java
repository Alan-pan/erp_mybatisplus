package com.zgjy.erp.service.impl;

import com.zgjy.erp.bean.Dept;
import com.zgjy.erp.mapper.DeptMapper;
import com.zgjy.erp.service.DeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    DeptMapper deptMapper;
}
