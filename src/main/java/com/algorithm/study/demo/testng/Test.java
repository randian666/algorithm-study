package com.algorithm.study.demo.testng;

import com.algorithm.study.demo.thread.SleepUtils;

public class Test {

    @org.testng.annotations.Test(threadPoolSize = 10, invocationCount = 10000)
    public void testJsf(){
        System.out.println("asdklfjalskfdj"+Thread.currentThread().getName());
    }
}
