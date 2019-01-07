package com.algorithm.study.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author: liuxun
 * @CreateDate: 2019/1/2 上午11:29
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);
            if (ref != null) {
                System.out.println("counter gc");
            }
        } catch (InterruptedException e) {
            // Handle it
        }

    }
}
