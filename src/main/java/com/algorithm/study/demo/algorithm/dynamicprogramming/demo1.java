package com.algorithm.study.demo.algorithm.dynamicprogramming;

/**
 * @author xun2.liu
 * @title: demo1
 * @projectName algorithm-study
 * @description: 动态规划-斐波那契数列
 * @date 2020/3/18 14:04
 */
public class demo1 {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
        System.out.println(fib3(10));
        System.out.println(fib4(10));
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

    /**
     * DP table 数组的迭代解法
     * 空间复杂度降为 O(N)
     *自底向上计算斐波那契数列
     * @param n
     * @return
     */
    private static int fib3(int n){
        int[] temp=new int[n+1];
        temp[1]=temp[2]=1;
        for (int i=3;i<=n;i++){
            temp[i]=temp[i-1]+temp[i-2];
        }
        return temp[n];
    }

    /**
     * DP table 数组的迭代解法优化
     * 空间复杂度降为 O(1)
     *自底向上计算斐波那契数列
     * @param n
     * @return
     */
    private static int fib4(int n){
        if (n==1 || n==2){
            return 1;
        }
        int prev=1;int curr=1;
        for (int i=3;i<=n;i++){
            int temp=prev+curr;
            prev=curr;
            curr=temp;
        }
        return curr;
    }
}
