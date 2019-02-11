package com.algorithm.study.demo.mode.decorator;

/**
 * 具体装饰类-
 * @Author: liuxun
 * @CreateDate: 2019/2/7 下午5:15
 * @Version: 1.0
 */
public class Milk extends  CondimentDecorator{
    protected Beverage beverage;
    public Milk(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",with milk";
    }

    @Override
    public double cost() {
        return 2+beverage.cost();
    }
}
