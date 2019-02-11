package com.algorithm.study.demo.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 求中位数的问题
 * @Author: liuxun
 * @CreateDate: 2019/1/31 下午1:57
 * @Version: 1.0
 */
public class MidNumCount {

    /** 大顶堆，用来存储前半部分的数据，如果完整为100，那此存储的为0-50 */
    private PriorityQueue<Integer> firstBigHeap =new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    /** 小顶堆,用来存储后半部分的数据，如果完整为100,那此存储的为51-100 */
    private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>(11);

    /** 元素的个数 */
    private int count;

    /**
     * 插入数据
     *
     * @param num 当前动态的数据集
     */
    public void putNum(int num) {

        count++;

        // 1,如果堆为空，则插入大顶堆中
        if (firstBigHeap.isEmpty() && afterLittleHeap.isEmpty()) {
            firstBigHeap.offer(num);
            return;
        }
        //奇数
        if (((firstBigHeap.size()+afterLittleHeap.size()) & 1)==1){
            //如果数据当前元素比大顶堆中的元素大，则插入小顶堆中
            if (afterLittleHeap.peek() > num) {
                afterLittleHeap.offer(num);

            }
        }else{

        }

    }

    /**
     * 返回中位数的数据
     *
     * @return
     */
    public int getMidValue() {
        return firstBigHeap.peek();
    }

    /**
     * 从一个堆向另一个堆中移动元素
     *
     * @param src
     * @param out
     */
    private void move(PriorityQueue<Integer> src, PriorityQueue<Integer> out, int runNum) {
        for (int i = 0; i < runNum; i++) {
            out.offer(src.poll());
        }
    }

    public static void main(String[] args) {

        int[] da=new int[]{5,6,4,1,2};

        System.out.println(6>>1);
        System.out.println(6&1);
    }
}
