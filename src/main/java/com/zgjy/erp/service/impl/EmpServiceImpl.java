package com.zgjy.erp.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zgjy.erp.api.PasswordUtil;
import com.zgjy.erp.bean.Emp;
import com.zgjy.erp.mapper.EmpMapper;
import com.zgjy.erp.service.EmpService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yupan
 * @since 2019-11-18
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public boolean login(Emp emp) {
        List<Emp> list = empMapper.selectList(new EntityWrapper<Emp>().eq("username", emp.getUsername()));
        if(!CollectionUtils.isEmpty(list)){
            if(PasswordUtil.verify(emp.getPassword(),list.get(0).getPassword())){
                return true;
            }
        }
        return false;
    }
}
