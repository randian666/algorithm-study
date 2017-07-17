package com.algorithm.study.demo.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理解决方案
 在JDK 1.3以后提供了动态代理的技术，允许开发者在运行期创建接口的代理实例。在Sun刚推出动态代理时，还很难想象它有多大的实际用途，
 现在我们终于发现动态代理是实现AOP的绝好底层技术。JDK的动态代理主要涉及到java.lang.reflect包中的两个类：Proxy和InvocationHandler。
 其中InvocationHandler是一个接口，可以通过实现该接口定义横切逻辑，在并通过反射机制调用目标类的代码，动态将横切逻辑和业务逻辑编织在一起。
 而Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例。
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
     1、需要实现InvocationHandler
     2、在invoke方法里面，实现动态代理， method是要被调用的方法
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
