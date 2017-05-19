package com.algorithm.study.demo.mode;

/**
 * Created by liuxun on 2017/5/11.
 */
public class RedShapeDecorator extends  ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    @Override
    public void doShaper() {
        System.out.println("do RedShapeDecorator doShaper");
        decoratedShape.doShaper();
    }

}
