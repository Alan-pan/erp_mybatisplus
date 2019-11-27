package com.zgjy.erp.api;

import com.zgjy.erp.controller.StoreController;
import com.zgjy.erp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
//步骤
//编写调用类
//编写对应的job.xml
public class MailJob {

    @Autowired
    private StoreService storeService;

    public void sendEmail(){
        System.out.println("------------");
        storeService.sendEmail();
    }
}
