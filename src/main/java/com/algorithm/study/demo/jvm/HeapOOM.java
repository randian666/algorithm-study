package com.algorithm.study.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxun
 * @version V1.0
 * @Description: VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails -XX:HeapDumpPath=E:\
 * @date 2017/11/28
 */
public class HeapOOM {
    /**
     * Java堆溢出实例
     * @param args
     */
    public static void main(String[] args) {
        List<HeapOOM> list=new ArrayList<>();
        while (true){
            list.add(new HeapOOM());
        }
    }
}
