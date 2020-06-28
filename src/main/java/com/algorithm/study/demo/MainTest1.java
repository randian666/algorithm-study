package com.algorithm.study.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xun2.liu
 * @title: MainTest1
 * @projectName algorithm-study
 * @description: TODO
 * @date 2020/6/24 17:30
 */
public class MainTest1 {
    public static void main(String[] args) {
        List<List<Integer>> lists=new ArrayList<>();
        if((lists.size() & 1)==1){
            LinkedList<Integer> ls=new LinkedList<>();
            //奇数层放到队列尾部
            ls.addLast(3);
            lists.add(ls);
        }else{
            LinkedList<Integer> ls=new LinkedList<>();
            //偶数层放到队列头部
            ls.addFirst(9);
            ls.addFirst(2);
            lists.add(ls);
        }

        System.out.println(JSON.toJSONString(lists));
        System.out.println((2 & 1));

    }
}
