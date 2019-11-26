package com.zgjy.test;

import com.zgjy.erp.bean.Emp;
import com.zgjy.erp.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test02 {
    @Test
    public void t1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-mapper.xml");
        EmpService empService = ioc.getBean(EmpService.class);
        Emp emp = empService.selectById(1);
        System.out.println(emp);
    }

    @Test
    public void t2() {
//        boolean b = VerifySquenceOfBST(new int[]{4, 6, 7, 5});
//        System.out.println(b);
    }

    @Test
    public void t3() {
        reConstructBinaryTree(new int[]{1,2,4,3,5,6},new int[]{4,2,1,5,3,6});
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length==0){
            return null;
        }
        TreeNode res = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return res;
        }

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                res.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                res.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return res;
    }
}
