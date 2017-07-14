package com.algorithm.study.demo.mode.templates;

/**
 * 模板方法抽象类
 * Created by liuxun on 2017/7/14.
 */
public abstract class TemplateAbstractClass implements TemplateInterface{
    /**
     * 模板方法
     * 为了防止恶意的操作，一般模板方法都加上final关键字，不允许被覆写
     * 一般是一个具体方法，也就是一个框架，实现对基本方法的调度，完成固定的逻辑。
     */
    @Override
    public final void execute() {
        preDoSomething();
        afterDoSomething();

    }
    //基本方法
    protected abstract void  preDoSomething();
    //基本方法
    protected abstract void afterDoSomething();
}
