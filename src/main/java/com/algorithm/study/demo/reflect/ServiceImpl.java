package com.algorithm.study.demo.reflect;

/**
 * Created by liuxun on 2017/7/17.
 */
public class ServiceImpl implements Service{
    @Override
    public void service(String arg) {
        System.out.println("service is called...arg : "+arg);
    }
}
