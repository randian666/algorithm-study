package com.algorithm.study.demo.mode;

/**
 * Created by liuxun on 2017/5/11.
 */
public abstract class ShapeDecorator implements Shape{

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void doShaper(){
        System.out.println("do ShapeDecorator doShaper");
        decoratedShape.doShaper();
    }
}
