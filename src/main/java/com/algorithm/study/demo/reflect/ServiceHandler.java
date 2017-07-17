package com.algorithm.study.demo.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理解决方案
 * Created by liuxun on 2017/7/17.
 */
public class ServiceHandler implements InvocationHandler {
    private Object target ;

    public ServiceHandler(Object target){
        this.target = target;
    }
    public Object createProxyIntance(){
        //这里调用JDK生成Proxy的地方，三个参数，类装载器，代理接口，proxy回调方法所在的对象
        return  Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    /**
     * 回调方法
     * @param proxy 代理对象
     * @param method 对象方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin();
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}
