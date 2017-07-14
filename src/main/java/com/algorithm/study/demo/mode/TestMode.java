package com.algorithm.study.demo.mode;

import com.algorithm.study.demo.mode.factory.HumanFactory;
import com.algorithm.study.demo.mode.factory.WhiteHuman;
import com.algorithm.study.demo.mode.singleton.EnumSingleton;
import com.algorithm.study.demo.mode.strategy.MemberStrategy;
import com.algorithm.study.demo.mode.strategy.Price;
import com.algorithm.study.demo.mode.strategy.PrimaryMemberStrategy;
import com.algorithm.study.demo.mode.templates.SubClassOne;
import com.algorithm.study.demo.mode.templates.SubClassTwo;
import com.algorithm.study.demo.mode.templates.TemplateInterface;

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
        //模板方法
        TemplateInterface subClassOne=new SubClassOne();
        TemplateInterface subClassTwo=new SubClassTwo();
        subClassOne.execute();
        subClassTwo.execute();

        //工厂模式
        WhiteHuman white = HumanFactory.createHuman(WhiteHuman.class);
        white.getColor();
    }
}
