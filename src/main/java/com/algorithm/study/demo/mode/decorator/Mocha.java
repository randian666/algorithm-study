package com.algorithm.study.demo.mode.decorator;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/7 下午5:17
 * @Version: 1.0
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public double cost() {
        return 1+beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",with Mocha";
    }
}
