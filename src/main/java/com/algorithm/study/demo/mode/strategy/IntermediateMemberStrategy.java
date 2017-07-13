package com.algorithm.study.demo.mode.strategy;

/**
 * 中级会员价格-策略
 * Created by LiuXun on 2017/7/13.
 */
public class IntermediateMemberStrategy implements MemberStrategy  {
    public double calcPrice(double bookePrice) {
        System.out.println("中级会员价格为："+bookePrice);
        return bookePrice;
    }
}
