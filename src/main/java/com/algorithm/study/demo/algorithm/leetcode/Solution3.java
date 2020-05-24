package com.algorithm.study.demo.algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xun2.liu
 * @title: Solution3
 * @projectName algorithm-study
 * @description:前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * @date 2020/5/13 16:28
 */
public class Solution3 {
    /**
     * 使用优先队列
     * 首先建立一个元素值对应出现频率的哈希表。在 Java 中使用 HashMap，但需要手工填值。
     * 这个步骤需要 O(N) 时间其中 NN 是列表中元素个数。
     * 第二步建立堆，堆中添加一个元素的复杂度是 O(\log(k))，要进行 NN 次复杂度是 O(N)。
     * 最后一步是输出结果，复杂度为 O(k\log(k))。
     * @param nums
     * @param k
     * @return
     */
    public  static int[] topKFrequent(int[] nums, int k) {

        //用来存储每个数字出现的次数
        Map<Integer,Integer> counter=new HashMap<>();
        for(int n:nums){
            counter.put(n,counter.getOrDefault(n,0)+1);
        }
        //使用每个数字出现的次数作为排序规则来建立初始化一个优先队列
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2)-> counter.get(n1)-counter.get(n2));
        //把数字写入优先队列中
        for(int num:counter.keySet()){
            heap.add(num);
            //如果优先队列中的元素大于前K个就删除，因为默认是升序。
            if(heap.size()>k){
                heap.poll();
            }
        }
        //取出前K个元素从优先队列中
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 3, 3, 3, 3, 5}, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
