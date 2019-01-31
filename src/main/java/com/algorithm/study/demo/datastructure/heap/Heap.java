package com.algorithm.study.demo.datastructure.heap;

import com.alibaba.fastjson.JSON;

/**
 * 堆
 * 堆就是一颗完全二叉树
 * 堆中每一个节点的值都必须大于等于（或者小于等于）其子树（左右子节点）中每个节点的值。
 * 堆顶存储的就是最大值或者最小值
 * 用数组存储非常节省存储空间，下标为id的节点的左子节点就是i*2的节点，右子节点的下标为i*2+1。父节点就是i/2的节点。
 *
 * @Author: liuxun
 * @CreateDate: 2019/1/31 上午10:30
 * @Version: 1.0
 */
public class Heap {
    private int[] data;
    private int count;//堆中元素的个数
    private int capacity;//堆容量

    /**
     * 初始化堆
     * @param capacity
     */
    public Heap(int capacity){
        this.capacity=capacity;
        data=new int[capacity];
        count=0;
    }

    /**
     * 往堆中插入数据
     * 从下往上的方法堆化
     * @param d
     */
    public void insert(int d){
        if (count>=capacity) return;//堆满了
        count++;//从下标为1开始填充数据
        data[count]=d;
        int i=count;
        while (i/2>0 && data[i]>data[i/2]){
            //交换数据
            swap(data,i,i/2);
            i=i/2;//切到父节点
        }
    }

    private static void swap(int[] a,int i,int n) {
        int temp=a[i];
        a[i]=a[n];
        a[n]=temp;
    }

    /**
     * 删除堆顶元素
     * 把最后一个元素放到对顶，然后从上到下的方法堆化。
     */
    public void removeMax(){
        data[1]=data[count];
        count--;
        int i=1;
        heapify(data,count,i);
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
        System.out.println(JSON.toJSONString(a));
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    // n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
    public static void sort(int[] a, int n) {
        buildHeap(a, n);//构建堆
        int k = n;
        while (k > 1) {
            swap(a, 1, k);//堆顶跟最后一个元素交换
            --k;//每次k-1，也就去取出
            heapify(a, k, 1);//1-k堆化
        }
        System.out.println(JSON.toJSONString(a));
    }


    public static void main(String[] args) {
//        Heap heap=new Heap(6);
//        for (int i=1;i<=5;i++){
//            heap.insert(i);
//        }
//        System.out.println(heap.count);

        int[] d = new int[]{0, 5, 2, 1, 4, 3};
        sort(d,d.length-1);
    }
}
