package com.algorithm.study.demo.mode.singleton;

/**
 * 单例设计模式-饱汉模式
 优点是：使用synchronized关键字避免多线程访问时，出现多个SingletonTest实例。
 缺点是：同步方法频繁调用时，效率略低。
 * Created by liuxun on 2017/7/13.
 */
public class SingletonTest2 {
    // 定义私有构造方法（防止通过 new SingletonTest2()去实例化）
    private SingletonTest2() {
    }
    // 定义一个SingletonTest类型的变量（不初始化，注意这里没有使用final关键字）
    private static SingletonTest2 instance;

    // 定义一个静态的方法（调用时再初始化SingletonTest，使用synchronized 避免多线程访问时，可能造成重的复初始化问题）
    public static synchronized SingletonTest2 getInstance(){
        if (instance==null) {
            instance = new SingletonTest2();
        }
        return instance;
    }
}
