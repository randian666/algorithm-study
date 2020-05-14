package com.algorithm.study.demo.algorithm.leetcode;


import java.util.*;

/**
 * @author xun2.liu
 * @title: Solution4
 * @projectName algorithm-study
 * @description: 两个整数相除得到循环小数，求循环节
 * @date 2020/5/14 19:01
 */
public class Solution4 {

    public static String function(int a, int b){
        //存储商和余数
        List<Map<Integer,Integer>> temp=new ArrayList<>();
        int value=0;
        int remainder=0;
        boolean flag=false;
        while (!flag){
            value=a / b;
            remainder= a%b;
            for (int i=0;i<temp.size();i++){
                Map<Integer, Integer> integerIntegerMap = temp.get(i);
                if (integerIntegerMap.containsKey(value) && integerIntegerMap.containsValue(remainder)){
                    flag=true;
                    break;
                }
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(value,remainder);
            temp.add(map);
            a=remainder*10;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=1;i<temp.size();i++){
            Map<Integer, Integer> integerIntegerMap = temp.get(i);
            integerIntegerMap.forEach((k,v)->{
                sb.append(k);
            });

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(function(1,7));
    }

}
