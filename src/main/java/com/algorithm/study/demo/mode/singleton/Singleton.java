package com.algorithm.study.demo.mode.singleton;

/**
 * 单例设计模式-单例模式的实现：饿汉式,线程安全 但效率比较低
 优点是：写起来比较简单，而且不存在多线程同步问题，避免了synchronized所造成的性能问题；
 缺点是：当类SingletonTest被加载的时候，会初始化static的instance，静态变量被创建并分配内存空间，从这以后，
 这个static的instance对象便一直占着这段内存（即便你还没有用到这个实例），当类被卸载时，静态变量被摧毁，并释放所占有的内存，因此在某些特定条件下会耗费内存。
 * Created by liuxun on 2017/7/13.
 */
public class Singleton {
    // 定义私有构造方法（防止通过 new Singleton()去实例化）
    private Singleton(){}
    // 将自身的实例对象设置为一个属性,并加上Static和final修饰符
    private static final Singleton instance=new  Singleton();
    // 静态方法返回该类的实例
    public static Singleton getInstance(){
        return instance;
    }
}
