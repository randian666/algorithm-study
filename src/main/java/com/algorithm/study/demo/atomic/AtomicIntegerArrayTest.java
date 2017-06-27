package com.algorithm.study.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by liuxun on 2017/6/27.
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[] { 1,2 };
    static AtomicIntegerArray array=new AtomicIntegerArray(value);

    public static void main(String[] args) {
        array.addAndGet(0,1);
        System.out.println(array.get(0));
        //需要注意的是，数组value通过构造方法传递进去，然后AtomicIntegerArray会将当前数组
        //复制一份，所以当AtomicIntegerArray对内部的数组元素进行修改时，不会影响传入的数组。
        System.out.println(value[0]);

    }
}
