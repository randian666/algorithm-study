package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution
 * @projectName algorithm-study
 * @description: TODO
 * @date 2020/5/9 14:42
 */
public class Solution {

    /**
     * 实现 int sqrt(int x) 函数。
     *     计算并返回 x 的平方根，其中 x 是非负整数。
     *
     *     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     *     示例 1:
     *
     *     输入: 4
     *     输出: 2
     *     示例 2:
     *
     *     输入: 8
     *     输出: 2
     *     说明: 8 的平方根是 2.82842...,由于返回类型是整数，小数部分将被舍去。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x==0){
            return 0;
        }
        if (x==1){
            return 1;
        }
        return x/2;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
