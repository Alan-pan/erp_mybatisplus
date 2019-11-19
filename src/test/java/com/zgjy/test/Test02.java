package com.zgjy.test;

import com.zgjy.erp.bean.Emp;
import com.zgjy.erp.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    @Test
    public void t1(){
        ApplicationContext ioc= new ClassPathXmlApplicationContext("spring-mapper.xml");
        EmpService empService = ioc.getBean(EmpService.class);
        Emp emp = empService.selectById(1);
        System.out.println(emp);
    }
}
