package com.algorithm.study.demo;

import com.alibaba.fastjson.JSON;
import com.ly.ie.common.utils.HessianUtils;
import com.ly.isbase.util.Base64Util;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @title: TestBase64
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/10/18 11:37
 */
public class TestBase64 {

    /**
     * BASE64解密
     * @throws Exception
     */
    public static Object decryptBASE64(String key) throws Exception {
        return  HessianUtils.fromBytes(Base64Util.decode(key));
    }
    /**
     * BASE64加密
     */
    public static String encryptBASE64(String key) throws Exception {
        return Base64Util.encodeToString(HessianUtils.toBytes(key));
    }
    /**
     * BASE64加密解密
     */
    public static void enAndDeCode(String str) throws Exception {
        System.out.println("压缩前长度："+str.length());
        String data = encryptBASE64(str);
        System.out.println("压缩后长度："+data.length());
        Object byteArray = decryptBASE64(data);
        FileUtils.write(new File("D:/78910.txt"),byteArray.toString(),"UTF-8");

        int num=10000;

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            encryptBASE64(str);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("压缩总耗时"+(endTime - beginTime));
        System.out.println("压缩平均耗时"+(endTime - beginTime) / 10000);

        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            decryptBASE64(data);
        }
        long endTimeMillis = System.currentTimeMillis();
        System.out.println("解压总耗时"+(endTimeMillis - currentTimeMillis));
        System.out.println("解压平均耗时"+(endTimeMillis - currentTimeMillis) / 10000);
    }
    public static void main(String[] args) throws Exception {
        String strOld = FileUtils.readFileToString(new File("D:/123456.txt"), "utf-8");
        enAndDeCode(strOld);
    }
}
