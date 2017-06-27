package com.algorithm.study.demo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuxun on 2017/6/27.
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.get());
        System.out.println(ai.addAndGet(1));//以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加，并返回结果。
        System.out.println(ai.getAndIncrement());//以原子方式将当前值加1，注意，这里返回的是自增前的值。
        System.out.println(ai.get());
        ai.compareAndSet(ai.get(),100);//检查当前的值是否被修改过，如果没修改过就更新
        System.out.println(ai.get());
    }
}
