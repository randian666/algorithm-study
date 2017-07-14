package com.algorithm.study.demo.mode.factory;

/**
 * Created by liuxun on 2017/7/14.
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("Black");
    }

    @Override
    public void talk() {
        System.out.println("Black man talk");
    }
}
