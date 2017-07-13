package com.algorithm.study.demo.mode.strategy;

/**
 * 初级会员价格
 * Created by LiuXun on 2017/7/13.
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    public double calcPrice(double bookePrice) {
        System.out.println("初级会员价格为："+bookePrice);
        return bookePrice;
    }
}
