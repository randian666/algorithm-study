package com.algorithm.study.demo.java8;

/**
 * Created by liuxun on 2017/7/10.
 */
public class Apple {
    private String color;
    private Integer weight;
    public Apple(){}
    public Apple(Integer weight){
        this.weight=weight;

    }
    public Apple(String color,Integer weight){
        this.color=color;
        this.weight=weight;

    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    public static boolean isGreenApple(Apple apple) {
        return  "green".equals(apple.getColor());
    }
    public boolean isHeavyApple(Apple apple) {
        return   apple.getWeight() > 150;
    }


}
