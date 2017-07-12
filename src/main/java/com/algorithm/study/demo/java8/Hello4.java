package com.algorithm.study.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Java8函数式接口-Predicate、Consumer、Function
 * Created by liuxun on 2017/7/11.
 */
public class Hello4 {
    public static void main(String[] args) {
        List<String> listOfStrings= Arrays.asList("asdf","","132",newBean(()->new String("333")));
        Predicate<String> notempty = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, notempty);
        foreach(nonEmpty,(String s)-> System.out.println(s));

        List<Integer> listLength = map(listOfStrings, (String s) -> s.length());
        foreach(listLength,(Integer i)-> System.out.println(i));

        int num=5656;
        Runnable o = () -> System.out.println(num);
        Thread t=newBean(()->new Thread(o));
        t.start();
    }

    /**
     * Predicate定义了抽象方法test,代表函数描述符是(T)->boolean
     * @param params
     * @param predicate
     * @return
     */
    public static List<String> filter(List<String> params,Predicate<String> predicate){
        List<String> list=new ArrayList<>();
        for (String str:params){
            if (predicate.test(str)){
                list.add(str);
            }
        }
        return list;
    }

    /**
     * Consumer定义了抽象方法accept,代表函数描述符是(T)->void
     * @param params
     * @param consumer
     * @param <T>
     */
    public static <T> void foreach(List<T> params, Consumer<T> consumer){
        for (T str:params){
            consumer.accept(str);
        }
    }

    /**
     *  Function定义了抽象方法apply,代表函数描述符是(T,R)->R
     * @param params
     * @param function
     * @return
     */
    public static List<Integer> map(List<String> params, Function<String,Integer> function){
        List<Integer> list=new ArrayList<>();
        for (String str:params){
            list.add(function.apply(str));
        }
        return list;
    }

    /**
     * IntPredicate定义了抽象方法test,代表函数描述符是(int i)->boolean
     * @param params
     * @param intPredicate
     * @return
     */
    public static List<Integer> filterInt(List<Integer> params,IntPredicate intPredicate){
        List<Integer> list=new ArrayList<>();
        for (Integer i:params){
            if (intPredicate.test(i)){
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Supplier定义了抽象方法get，代表函数描述符是()->T
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> T newBean(Supplier<T> supplier){
            return supplier.get();
    }


}
