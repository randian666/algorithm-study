package com.algorithm.study.demo.algorithm;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/13 下午3:11
 * @Version: 1.0
 */
public class Solution {

    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            result = 0;
        return (int)result;
    }
}
