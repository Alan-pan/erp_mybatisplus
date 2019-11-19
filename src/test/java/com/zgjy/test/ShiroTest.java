package com.zgjy.test;

import com.zgjy.erp.api.PasswordUtil;
import org.junit.Test;

public class ShiroTest {
    @Test
    public void t1(){
        String generate = PasswordUtil.generate("123");
        System.out.println(generate);
        System.out.println(PasswordUtil.verify("123",generate));
    }
}
