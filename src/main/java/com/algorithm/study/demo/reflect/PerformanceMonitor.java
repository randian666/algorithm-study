package com.algorithm.study.demo.reflect;

/**
 * 我们想在执行Service的service方法的前后加入PerformanceMonitor的begin和end
 * Created by liuxun on 2017/7/17.
 */
public class PerformanceMonitor {
    public static void  begin(){
        System.out.println("监控开始...");
    }

    public static void end(){
        System.out.println("监控结束...");
    }
}
