package com.algorithm.study.demo.reflect;

import java.lang.reflect.Proxy;

/**
 * 动态代理实现
 * Created by liuxun on 2017/7/17.
 */
public class Test {
    public static void main(String[] args) {
        Service service=new ServiceImpl();
        ServiceHandler serviceHandler=new ServiceHandler(service);
        Service proxy = (Service)serviceHandler.createProxyIntance();
//        Service proxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),serviceHandler);
        proxy.service("hello reflect");
    }
}
