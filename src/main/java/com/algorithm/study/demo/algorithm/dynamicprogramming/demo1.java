package com.algorithm.study.demo.algorithm.dynamicprogramming;

/**
 * @author xun2.liu
 * @title: demo1
 * @projectName algorithm-study
 * @description: 动态规划
 * @date 2020/3/18 14:04
 */
public class demo1 {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }

    /**
     * 重叠子问题，子问题个数为 O(2^n)。性能非常低。
     * @param n
     * @return
     */
    private static int fib(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * 带备忘录的递归解法,解决重叠子问题。
     * 子问题个数为 O(n),时间复杂度是 O(n)
     * @param n
     * @return
     */
    private static int fib2(int n){
        if(n==1 || n==2){
            return 1;
        }
        int[] memo=new int[n+1];
        return helper(memo,n);
    }
    private static  int helper(int[] memo,int n){
        if(n==1 || n==2){
            return 1;
        }
        if (memo[n]!=0) {
            return memo[n];
        }
        return memo[n]=helper(memo,n-1)+helper(memo,n-2);
    }
}
