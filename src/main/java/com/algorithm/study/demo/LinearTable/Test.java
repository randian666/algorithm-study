package com.algorithm.study.demo.LinearTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxun on 2017/6/14.
 */
public class Test {
    public static void main(String[] args) {
        MList<String> list=new MyArrayList<String>();
        list.addElem(0,"hello2");
        list.addElem(0,"hello1");
//        list.setElem(0,"hello3");
        list.add("hello4");
        list.del("hello4");
//        list.delElem(0);
        for (int i=0;i<list.size();i++){
            System.out.println(list.getElem(i));
        }
        System.out.println(list.size());
        List<String> list2=new ArrayList<String>();
        list2.add("2");
        list2.remove("2");
    }
}
