package com.algorithm.study.demo.mode.decorator;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/7 下午5:13
 * @Version: 1.0
 */
public abstract class Beverage {
    protected String description="";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
