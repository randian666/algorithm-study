package com.algorithm.study.demo;


/**
 * @title: TestDemo
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/10/21 17:16
 */
public class TestDemo {
    public static void main(String[] args) {
//        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5,6,7,8,9,10);
//        List<List<Integer>> partition = Lists.partition(integers, 3);
//        for (List<Integer> integerList : partition) {
//            for (int i = 0; i < integerList.size(); i++) {
//                System.out.println(integerList.get(i));
//                integerList.set(i,null);
//            }
//        }

//        int totalNum=2000;
//        int pageSize=1000;
//        int pageNo=(totalNum+pageSize-1)/pageSize;
//        System.out.println(getFrom(3,1000));
        System.out.println(".17usoft.com".length());
    }

    public static int getFrom(int pageNo,int pageSize) {
        if (pageNo<=1){
            return 0;
        }
        return (pageNo - 1) * pageSize;
    }
}
