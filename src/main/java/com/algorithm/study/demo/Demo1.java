package com.algorithm.study.demo;

import java.math.BigDecimal;

/**
 * @title: Demo1
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/9/24 15:59
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        BigDecimal b = new BigDecimal(0.115);
        double d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);
    }
    // 将字符串转换成二进制字符串，以空格相隔
    private static String StrToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + " ";
        }
        return result;
    }
}
