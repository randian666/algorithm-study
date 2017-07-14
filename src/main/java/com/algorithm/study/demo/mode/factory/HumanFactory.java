package com.algorithm.study.demo.mode.factory;

/**
 * 工厂抽象实现
 * Created by liuxun on 2017/7/14.
 */
public class HumanFactory {
    public static <T extends Human> T createHuman(Class<T> clazz) {
        Human human=null;
        try {
            human=(Human)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("没有该人类");
        }
        return (T)human;
    }
}
