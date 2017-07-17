package com.algorithm.study.demo.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理解决方案
 *
 1、需要实现InvocationHandler
 2、在invoke方法里面，实现动态代理， method是要被调用的方法
 * Created by liuxun on 2017/7/17.
 */
public class ServiceHandler implements InvocationHandler {
    private Object target ;

    public ServiceHandler(Object target){
        this.target = target;
    }

    /**
     * Proxy负责生成一个代理的实例
     * 这个实例在调用service方法的时候，改成了调用serviceHandler的invoke方法，从而把begin和end的动作插入。
     * @return
     */
    public Object createProxyIntance(){
        //这里调用JDK生成Proxy的地方，三个参数，类装载器，代理接口，proxy回调方法所在的对象
        return  Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    /**
     * 回调方法
     * @param proxy 代理对象
     * @param method 调用的方法
     * @param args 调用的方法参数
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
