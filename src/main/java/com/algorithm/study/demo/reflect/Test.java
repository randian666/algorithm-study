package com.algorithm.study.demo.reflect;

import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;

/**
 * 动态代理实现
 *Spring 实现AOP是依赖JDK动态代理和CGLIB代理实现的。
 JDK动态代理：其代理对象必须是某个接口的实现，它是通过在运行期间创建一个接口的实现类来完成对目标对象的代理。
 CGLIB代理：实现原理类似于JDK动态代理，只是它在运行期间生成的代理对象是针对目标类扩展的子类。CGLIB是高效的代码生成包，底层是依靠ASM（开源的java字节码编辑类库）操作字节码实现的，性能比JDK强。

 如果目标对象是接口类，适合使用JDK的方式生成代理对象，当没有接口时，将采用cglib中的方式实现proxy代理对象。
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
