package com.algorithm.study.demo.algorithm;

/**
 * 贪心算法
 * @Author: liuxun
 * @CreateDate: 2019/3/22 上午11:01
 * @Version: 1.0
 */
public class TanxinSolution {
    public static void main(String[] args) {
        TanxinSolution.greedyGiveMoney(10);
    }
    /**
     * 钱币找零问题
     *假设1元、2元、5元、10元、20元、50元、100元的纸币，张数不限制，现在要用来支付K元，至少要多少张纸币？
     * @param money the money
     */
    public static void greedyGiveMoney(int money) {
        System.out.println("需要找零: " + money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i=moneyLevel.length-1;i>=0;i--){
            int num=money/moneyLevel[i];//张数
            int mod=money%moneyLevel[i];//剩余的钱
            money=mod;
            if (num>0){
                System.out.println("最少需要"+num+"张"+moneyLevel[i]+"元的纸币");
            }
        }
    }
}
