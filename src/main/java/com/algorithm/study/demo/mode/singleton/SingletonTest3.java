package com.algorithm.study.demo.mode.singleton;

/**
 * 单例模式最优方案
 * 线程安全  并且效率高
 * Created by liuxun on 2017/7/13.
 */
public class SingletonTest3 {

    // 定义私有构造方法（防止通过 new SingletonTest3()去实例化）
    private SingletonTest3(){}

    //定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
    private static volatile SingletonTest3 instance;
    //线程安全-双重检验锁
    public static SingletonTest3 getInstance(){
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if (instance==null){
            //同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized (SingletonTest3.class) {
                //未初始化，则初始instance变量
                if (instance == null) {
                    instance = new SingletonTest3();
                    //在这个操作中，JVM主要干了三件事
                    //1、在堆空间里分配一部分空间；
                    //2、执行SingletonTest3的构造方法进行初始化；
                    //3、把instance对象指向在堆空间里分配好的空间。
                    //但是，当我们编译的时候，编译器在生成汇编代码的时候会对流程顺序进行优化。优化的结果是有可能按照1-2-3顺序执行，也可能按照1-3-2顺序执行。
                }
            }
        }
        return instance;
    }
}
