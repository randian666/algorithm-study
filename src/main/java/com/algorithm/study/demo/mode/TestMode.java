package com.algorithm.study.demo.mode;

import com.algorithm.study.demo.mode.singleton.EnumSingleton;

/**
 * Created by liuxun on 2017/7/13.
 */
public class TestMode {
    public static void main(String[] args) {
        EnumSingleton obj1 = EnumSingleton.getInstance();
        EnumSingleton obj2 = EnumSingleton.getInstance();
        //输出结果：obj1==obj2?true
        System.out.println("obj1==obj2?" + (obj1==obj2));
    }
}
