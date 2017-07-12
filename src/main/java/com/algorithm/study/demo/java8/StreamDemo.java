package com.algorithm.study.demo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流
 * stream 串行执行
 *parallelStream 并行处理
 * Created by liuxun on 2017/7/12.
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Apple> appleList=new ArrayList<>();
        appleList.add(new Apple("red",110));
        appleList.add(new Apple("green",120));
        appleList.add(new Apple("blue",200));
        List<String> list2 = appleList.parallelStream()
                .filter((a) -> a.getWeight() > 110)  //过滤
                .sorted(Comparator.comparing((Apple a)->a.getWeight()).reversed())//排序;
                .map((Apple a) -> a.getColor())
                .collect(Collectors.toList());
        list2.forEach((String s)-> System.out.println(s));

    }
}
