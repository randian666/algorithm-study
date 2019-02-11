package com.algorithm.study.demo.mode.decorator;

/**
 * 具体的实现类
 * @Author: liuxun
 * @CreateDate: 2019/2/7 下午5:13
 * @Version: 1.0
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description="House Bleand coffee";
    }
    @Override
    public double cost() {
        return 4;
    }
}
