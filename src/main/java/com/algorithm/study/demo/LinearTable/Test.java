package com.algorithm.study.demo.LinearTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuxun on 2017/6/14.
 */
public class Test {
    public static void main(String[] args) {
//        MList<String> list=new MyArrayList<String>();
//        list.addElem(0,"hello2");
//        list.addElem(0,"hello1");
////        list.setElem(0,"hello3");
//        list.add("hello4");
//        list.del("hello4");
////        list.delElem(0);
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.getElem(i));
//        }
//        System.out.println(list.size());
//        List<String> list2=new ArrayList<String>();
//        list2.add("2");
//        list2.remove("2");
//
//        LinkedList<String> list3=new LinkedList<String>();
//        list3.add("a");
//        list3.add("b");
//        list3.add(1,"c");
//        list3.addFirst("d");
//        list3.addFirst("c");
//        list3.getLast();
//        for (int i=0;i<list3.size();i++){
//            System.out.println(list3.get(i));
//        }

//        MLinkList<String> linkList=new MLinkList<String>();
//        linkList.addFirst("A");
//        linkList.addFirst("B");
//        linkList.addFirst("C");

//        linkList.delete(3);
//        linkList.add("A");
//        linkList.add("B");
//        linkList.add("C");
//        linkList.add("D");
//        linkList.add(2,"D");
//        linkList.add("E");
//        linkList.delete(4);
//        linkList.set(2,"PPP");
//        linkList.delete("D");
//        linkList.clear();
//        System.out.println("已删除头结点："+linkList.deleteFirst());
//        for (int i=0;i<linkList.size();i++){
//            System.out.println(linkList.get(i));
//        }


        TwoLinkList<String> twoLinkList=new TwoLinkList<String>();
        twoLinkList.addFirst("A");
        twoLinkList.addFirst("B");
        twoLinkList.addFirst("C");
        twoLinkList.addLast("D");
        twoLinkList.add("E");
//        System.out.println("头元素："+twoLinkList.getFirst());
//        System.out.println("尾元素："+twoLinkList.getLast());
        System.out.println("删除后的头元素："+twoLinkList.deleteFirst());
        System.out.println("删除后的尾元素："+twoLinkList.deleteLast());
//        twoLinkList.set(0,"KKK");
        for (int i=0;i<twoLinkList.size();i++){
            System.out.println(twoLinkList.get(i));
        }
        System.out.println("头元素："+twoLinkList.getFirst());
        System.out.println("尾元素："+twoLinkList.getLast());
    }
}
