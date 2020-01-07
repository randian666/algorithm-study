package com.algorithm.study.demo.enums;

/**
 * @author xun2.liu
 * @title: Calculator
 * @projectName algorithm-study
 * @description: TODO
 * @date 2020/1/7 14:51
 */
public class Calculator{

    public int apply(int a, int b,Operator operator) {
        return operator.apply(a,b);
    }
}
