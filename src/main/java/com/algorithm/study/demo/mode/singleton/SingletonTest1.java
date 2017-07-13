package com.algorithm.study.demo.mode.singleton;

/**
 * 单例设计模式-饱汉模式
 * 优点是：写起来比较简单，当类SingletonTest被加载的时候，静态变量static的instance未被创建并分配内存空间，当getInstance方法第一次被调用时，初始化instance变量，
 * 并分配内存，因此在某些特定条件下会节约了内存；缺点是：并发环境下很可能出现多个SingletonTest实例。
 * Created by liuxun on 2017/7/13.
 */
public class SingletonTest1 {
    // 定义私有构造方法（防止通过 new SingletonTest1()去实例化）
    private SingletonTest1() {
    }
    // 定义一个SingletonTest类型的变量（不初始化，注意这里没有使用final关键字）
    private static SingletonTest1 instance;

    // 定义一个静态的方法（调用时再初始化SingletonTest，但是多线程访问时，可能造成重复初始化问题）
    public static SingletonTest1 getInstance(){
        if (instance==null)
            instance= new SingletonTest1();
        return instance;
    }
}
