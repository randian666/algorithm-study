package com.algorithm.study.demo.mode.decorator;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/7 下午5:24
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Beverage beverage=new Milk(new Mocha(new HouseBlend()));
        System.out.println(beverage.getDescription()+",cost:"+beverage.cost());
    }
}
