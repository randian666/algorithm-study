package com.algorithm.study.demo.enums;

import com.algorithm.study.demo.JodaTimeUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xun2.liu
 * @title: MainTest
 * @projectName algorithm-study
 * @description: 枚举类解决IF ESLE问题
 * @date 2019/12/13 16:32
 */
public class MainTest{
    public static void main(String[] args) throws ParseException {
        Calculator calculator=new Calculator();
        int result=calculator.apply(2,4,Operator.ADD);
        System.out.println(result);
    }

}
