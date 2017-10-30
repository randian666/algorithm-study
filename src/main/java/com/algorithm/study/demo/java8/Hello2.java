package com.algorithm.study.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 匿名类实现行为参数化
 * Created by liuxun on 2017/7/10.
 */
public class Hello2 {
    public static void main(String[] args) {
        List<Apple> list= Arrays.asList(new Apple("red",1),new Apple("green",133),new Apple("blue",166));
        List<Apple> list2=filterApple(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>133;
            }
        });
        list2.forEach((Apple a)-> System.out.println(a.getColor()));

    }
    public static List<Apple> filterApple(List<Apple> list,ApplePredicate predicate){
        List<Apple> l=new ArrayList<>();
        for (Apple a:list){
            if (predicate.test(a)){
                l.add(a);
            }
        }
        return l;
    }
}
