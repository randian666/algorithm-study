package com.algorithm.study.demo.java8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 方法引用
 * Created by liuxun on 2017/7/11.
 */
public class Hello5 {

    public static void main(String[] args) {
        List<String> str= Arrays.asList("a","b","D","c","f");
//        str.sort((String o1,String o2)->o1.compareToIgnoreCase(o2));
        str.sort(String::compareToIgnoreCase);
        str.forEach((String s)-> System.out.println(s));

        //实例化对象-调用构造方法
        BiFunction<String,Integer,Apple> a=Apple::new;
        Apple apple = a.apply("red",222);
        System.out.println(apple.getColor());

        List<Integer> we=Arrays.asList(1,2,3,4,5,6);
        map(we,Apple::new);

        List<Apple> appleList=new ArrayList<>();
        appleList.add(new Apple("red",110));
        appleList.add(new Apple("green",110));
        appleList.add(new Apple("blue",200));
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor).reversed());
        appleList.forEach((Apple apple1)-> System.out.println(apple1.getColor()+":"+apple1.getWeight()));
        System.out.println("————————————————————————————————");
        Predicate<Apple> preWeight=(Apple k)->k.getWeight()>110;
//        Predicate<Apple> negateApple=preWeight.negate();
        Predicate<Apple> red=preWeight.and((Apple k)->k.getColor().equals("blue")).or(k->k.getColor().equals("red"));
        List<Apple> listRe = filter(appleList, preWeight.negate());
        listRe.forEach(ab-> System.out.println(ab.getColor()+":"+ab.getWeight()));
        System.out.println("————————————————————————————————");
        Function<Integer,Integer> f=(x)->x+1;
        Function<Integer,Integer> g=(x)->x*2;
        Function<Integer,Integer> h=f.andThen(g);//先执行f然后执行g
        System.out.println(h.apply(1));

        Function<Integer,Integer> r=f.compose(g);//先执行g然后执行f
        System.out.println(r.apply(1));
        System.out.println("————————————————————————————————");
        Apple ap=new Apple("green",22);
        Predicate<Apple> isGreenApple=Apple::isGreenApple;//指向静态方法的方法引用 此方法只能是static
        System.out.println(isGreenApple.test(ap));
        Predicate<Apple> isHeavyApple=ap::isHeavyApple;//指向现有对象的实例方法的方法引用 此方法不能是static修饰的

        System.out.println(isHeavyApple.test(ap));
        Function<Integer,Integer> function=Integer::intValue;
        System.out.println(function.apply(456465));//指向任意类型实例方法的方法引用



    }
    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer e: list){
            result.add(f.apply(e));
        }
        return result;
    }
    public static <T> List<T> filter(List<T> params,Predicate<T> predicate){
        List<T> list=new ArrayList<>();
        for (T b:params){
            if (predicate.test(b)){
                list.add(b);
            }
        }
        return list;
    }

}
