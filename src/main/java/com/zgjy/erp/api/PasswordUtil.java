package com.zgjy.erp.api;


import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.util.Random;

public class PasswordUtil {
    //实现密码加密
    public static String generate(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();//加盐
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    //密码校验
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    //采用shiro框架加密保持一致
    public static String shiroMD5(String username){
        //加密方式
        String hashAlgorithmName = "MD5";
        //String credentials = "123456";
        //盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(username+"erp");
        //加密次数
        int hashIterations = 2;
        Object obj = new SimpleHash(hashAlgorithmName, "123", credentialsSalt, hashIterations);
        return obj.toString();
    }

    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String admin = PasswordUtil.shiroMD5("admin");
        System.out.println(admin);

        SimpleHash simpleHash = new SimpleHash("MD5", "123", ByteSource.Util.bytes("adminerp"), 2);
        System.out.println(simpleHash);
    }
}
