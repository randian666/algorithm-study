package com.algorithm.study.demo.mode;

import com.algorithm.study.demo.mode.factory.HumanFactory;
import com.algorithm.study.demo.mode.factory.WhiteHuman;
import com.algorithm.study.demo.mode.proxy.GamePlayer;
import com.algorithm.study.demo.mode.proxy.IGamePlayer;
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
        /**
         * 策略模式定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换，策略模式让算法独立于使用它的客户而独立变化。
         * 策略模式的缺点：
         * 1、客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
         * 2、策略模式造成很多的策略类，每个具体策略类都会产生一个新类。
         */
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
