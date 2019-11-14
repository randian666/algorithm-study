package com.algorithm.study.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @title: Demo1
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/9/24 15:59
 */
public class Demo1 {
    public static void main(String[] args) {
        TreeMap<BigDecimal, String> pairs = new TreeMap<>(Comparator.reverseOrder());
        pairs.put(new BigDecimal("10000000000000"),"c");

        pairs.put(new BigDecimal("1000"),"a");
        pairs.put(new BigDecimal("1000"),"d");
        pairs.put(new BigDecimal(String.valueOf(Integer.MAX_VALUE)),"b");

        Iterator<BigDecimal> iterator =  pairs.keySet().iterator();
        while(iterator.hasNext()) {
            BigDecimal key = iterator.next();
            System.out.println("Key: " + key + ", Value: " + pairs.get(key));
        }
    }
}
