package com.uv.cer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class MD5Helper {
    String basic = "thinking in java";
    String publicKey = "rY0D^0'nM0}g5Mm1z%1G4";

    public void execute()
    {
        cer(basic,publicKey);
    }

    public void cer(String basic,String publicKey) {
        String salt = geSalt();
        String code = basic + salt + publicKey;
        String sign = md5Hash(code);
        System.out.println("basic is : " + basic);
        System.out.println("salt is : " + salt);
        System.out.println("sign is : " + sign);
    }

    public String geSalt()
    {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        String salt =  Long.toString(timeStampMillis);
        return salt;
    }

    //转MD5摘要
    public String md5Hash(String message) {
        String md5 = "";
        if (null == message)
            return null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");//生成摘要实例
            digest.update(message.getBytes(), 0, message.length());//更新输入摘要
            md5 = new BigInteger(1, digest.digest()).toString(16);//生成16进制摘要

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
