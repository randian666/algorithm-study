package com.algorithm.study.demo.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liuxun
 * @version V1.0
 * @Description: Cglib动态代理；cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。
 * @date 2017/12/1
 */
public class CGlibProxyFactory implements MethodInterceptor{
    private Object target;
    /**
     * 回调方法
     * @param proxy
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin();
        method.invoke(target,args);
        PerformanceMonitor.end();
        return null;
    }

    public Object getInstance(Object target){
        this.target=target;
        //通过enhancer生成代理对象
        Enhancer enhancer=new Enhancer();
        //设置目标类的子类，该子类会覆盖所有父类中的非final方法
        enhancer.setSuperclass(this.target.getClass());
        //设置回调方法
        enhancer.setCallback(this);
        return enhancer.create();
    }


}
