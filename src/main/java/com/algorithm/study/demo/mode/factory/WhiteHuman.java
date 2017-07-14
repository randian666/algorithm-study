package com.algorithm.study.demo.mode.factory;

/**
 * 白种人
 * Created by liuxun on 2017/7/14.
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("White");
    }

    @Override
    public void talk() {
        System.out.println("White man talk");
    }
}
