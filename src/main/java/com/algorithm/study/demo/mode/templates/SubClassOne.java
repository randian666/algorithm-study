package com.algorithm.study.demo.mode.templates;

/**
 * 基本方法的具体实现
 * Created by liuxun on 2017/7/14.
 */
public class SubClassOne extends  TemplateAbstractClass{

    @Override
    public void preDoSomething() {
        System.out.println("SubClassOne do preDoSomething");
    }

    @Override
    public void afterDoSomething() {
        System.out.println("SubClassOne do afterDoSomething");
    }
}
