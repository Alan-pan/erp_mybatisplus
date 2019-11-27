package com.zgjy.test;

import com.zgjy.erp.api.MailHelper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailTest {
    @Test
    public void t1(){
        ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("classpath:spring.xml");
        MailHelper bean = spring.getBean(MailHelper.class);
        System.out.println(bean.getSender().createMimeMessage());

    }
}
