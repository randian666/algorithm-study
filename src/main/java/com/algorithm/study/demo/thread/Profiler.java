package com.algorithm.study.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal，即线程变量，是一个以ThreadLocal对象为键、任意对象为值的存储结构。这
 个结构被附带在线程上，也就是说一个线程可以根据一个ThreadLocal对象查询到绑定在这个
 线程上的一个值。
 * Created by liuxun on 2017/6/16.
 */
public class Profiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
