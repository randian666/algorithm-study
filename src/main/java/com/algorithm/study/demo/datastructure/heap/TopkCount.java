package com.algorithm.study.demo.datastructure.heap;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;

/**
 * @Author: liuxun
 * @CreateDate: 2019/1/30 下午8:10
 * @Version: 1.0
 */
public class TopkCount {
    /**
     * 求数据中前K大数据
     *
     * @param data
     * @param k
     * @return
     */
    public static int topk(int[] data, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < data.length; i++) {
            if (queue.size() < k) {
                queue.offer(data[i]);
            } else {
                int value = queue.peek();
                // 如果发现数据比堆顶元素大，则加入到小顶堆中
                if (data[i] > value) {
                    queue.poll();//删除
                    queue.offer(data[i]);
                }
            }
        }
        return queue.peek();
    }

    /**
     * 手动实现堆然后查找topK
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        //构建一个小顶堆数组
        int[] out = new int[k];
        //小顶堆元素数量
        int count = 0;
        //循环处理数组
        for (int i=0;i<nums.length;i++){
            //数组没有满之前,从下向上调整
            if(count<k){
                out[i] = nums[i];
                count++;
                down2up(out,i);
            }else{
                //数组满了以后，如果新元素大于堆顶则替换堆顶，然后从上向下调整
                if(nums[i]>out[0]){
                    out[0] = nums[i];
                    up2down(out,0);
                }
            }
        }
        return out[0];
    }

    //从下向上调整,构建小顶堆
    public static void down2up(int[] nums,int i){
        int parent = (i-1)/2;
        while(parent>=0&&nums[i]<nums[parent]){
            swap(nums,i,parent);
            i = parent;
            parent = (i-1)/2;
        }
    }

    //从上向下调整，构建小顶堆
    public static void up2down(int[] nums,int p){
        while(true){
            int left  = 2*p+1;
            int right = 2*p+2;
            int minpos = p;
            if(left<nums.length&&nums[left]<nums[p]) minpos=left;
            if(right<nums.length&&nums[right]<nums[minpos]) minpos=right;
            if(minpos==p) break;
            swap(nums,p,minpos);
            p = minpos;
        }
    }

    private static void swap(int[] nums, int i, int parent) {
        int tmp = nums[i];
        nums[i] = nums[parent];
        nums[parent] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1,2,3,4,5},2));
    }
}
