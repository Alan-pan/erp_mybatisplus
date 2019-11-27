package com.zgjy.test;

import com.zgjy.erp.api.PasswordUtil;
import com.zgjy.erp.bean.StoreWarn;
import com.zgjy.erp.mapper.StoreWarnMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ShiroTest {
    @Test
    public void t1(){
        String generate = PasswordUtil.generate("123");
        System.out.println(generate);
        System.out.println(PasswordUtil.verify("123",generate));
    }
    @Test
    public void t2(){
        ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("classpath:spring.xml");
        StoreWarnMapper sw = spring.getBean(StoreWarnMapper.class);
        List<StoreWarn> list = sw.selectList(null);
        System.out.println(list);
    }
}
