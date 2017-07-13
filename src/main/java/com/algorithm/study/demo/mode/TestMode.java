package com.algorithm.study.demo.mode;

import com.algorithm.study.demo.mode.singleton.EnumSingleton;
import com.algorithm.study.demo.mode.strategy.MemberStrategy;
import com.algorithm.study.demo.mode.strategy.Price;
import com.algorithm.study.demo.mode.strategy.PrimaryMemberStrategy;

/**
 * Created by liuxun on 2017/7/13.
 */
public class TestMode {
    public static void main(String[] args) {
        //单例模式
        EnumSingleton obj1 = EnumSingleton.getInstance();
        EnumSingleton obj2 = EnumSingleton.getInstance();
        //输出结果：obj1==obj2?true
        System.out.println("obj1==obj2?" + (obj1==obj2));
        //策略模式
        MemberStrategy memberStrategy=new PrimaryMemberStrategy();
        Price price=new Price(memberStrategy);
        price.quote(2222);
    }
}
