package com.algorithm.study.demo.java8;

import org.testng.Assert;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author xun2.liu
 * @title: FunctionTest
 * @projectName algorithm-study
 * @description: Consumer实例
 * @date 2019/12/20 15:19
 */
public class FunctionTest {
    public static void main(String[] args) {
//        consumerTest();
        functionTest();
    }

    /***
     * Consumer是一个函数式编程接口； 顾名思义，Consumer的意思就是消费，即针对某个东西我们来使用它，因此它包含有一个有输入而无输出的accept接口方法；
     * 除accept方法，它还包含有andThen这个方法；
     */
    public static void consumerTest() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
//        f.andThen(f).andThen(f).andThen(f).accept("test1");
    }

    /**
     * Function测试
     * Function也是一个函数式编程接口；它代表的含义是“函数”，而函数经常是有输入输出的，因此它含有一个apply方法，
     * 包含一个输入与一个输出；除apply方法外，它还有compose与andThen及indentity三个方法
     */
    public static void functionTest() {
        Function<Integer, Integer> f = s -> s++;
        Function<Integer, Integer> g = s -> s * 2;

        /**
         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
         * 相当于以下代码：
         * Integer a = g.apply(1);
         * System.out.println(f.apply(a));
         */
        System.out.println(f.compose(g).apply(1));

        /**
         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
         * 相当于以下代码
         * Integer a = f.apply(1);
         * System.out.println(g.apply(a));
         */
        System.out.println(f.andThen(g).apply(1));

        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         */
        System.out.println(Function.identity().apply("a"));
    }



    /**
     * Predicate测试
     * Predicate为函数式接口，predicate的中文意思是“断定”，即判断的意思，判断某个东西是否满足某种条件；
     * 因此它包含test方法，根据输入值来做逻辑判断，其结果为True或者False。
     */
    private static void predicateTest() {
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> g = o -> o.startsWith("t");

        /**
         * negate: 用于对原来的Predicate做取反处理；
         * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
         */
        Assert.assertFalse(p.negate().test("test"));

        /**
         * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
         */
        Assert.assertTrue(p.and(g).test("test"));

        /**
         * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
         */
        Assert.assertTrue(p.or(g).test("ta"));
    }
}
