package com.algorithm.study.demo.java8;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by liuxun on 2017/7/10.
 */
public class Hello {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,6,7,2,3,4);
        list.sort(Comparator.comparing(Integer::intValue));
        list.sort((Integer i,Integer j)->i.compareTo(j));

        for (Integer a:list) {
            System.out.println(a);
        }

        File[] fs = new File("E:\\download").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        File[] f2= new File("E:\\download").listFiles(File::isHidden);
        for (File f:f2){
            System.out.println(f.getName());
        }
        List<Apple> inventory=new ArrayList<>();
        inventory.add(new Apple("green",100));
        inventory.add(new Apple("red",110));
        inventory.add(new Apple("blue",150));

        //方法应用，把方法作为值来传递
        List<Apple> nl = filterApples(inventory, Apple::isGreenApple);
        for (Apple a:nl){
            System.out.println(a.getColor());
        }
        //匿名函数(Lambda),把方法作为值来传递
        List<Apple> nl2 = filterApples(inventory,(Apple a)->a.getWeight() > 110);
        for (Apple a:nl2){
            System.out.println(a.getColor());
        }
        //流操作数据
        Map<String,List<Apple>> map=new HashMap<>();
        List<Apple> s = inventory.stream().filter((Apple a) -> a.getWeight() > 110).collect(Collectors.toList());//串行处理
        s.forEach((Apple a)-> System.out.println(a.getColor()));
        List<Apple> s2=inventory.parallelStream().filter((Apple a) -> a.getWeight() > 110).collect(Collectors.toList());//并行处理
        s2.forEach((Apple a)-> System.out.println(a.getColor()));

        Thread t=new Thread(()-> System.out.println(Thread.currentThread().getName()));
        t.start();

    }
    public Callable<String> fetch() {
        return () -> "Tricky example  ;-)";
    }
    /**
     * 把方法作为值来传递
     * Predicate<T>，而这是一个函数式接口
     * @param inventory
     * @param p
     * @return
     */
    public static <T> List<T> filterApples(List<T> inventory, Predicate<T> p ) {
        List<T> result = new ArrayList<>();
        for (T a: inventory){
            if (p.test(a) ) {
                result.add(a);
            }
        }
        return result;
    }
}
