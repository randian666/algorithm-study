package com.algorithm.study.demo.datastructure.tree;

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
    public static int[] topk(int[] data, int k) {
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

        int[] result = new int[k];
        int index = 0;
        // 遍历完成后，小顶堆的数据就为需要求得的topk的数据
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(topk(new int[]{1,2,3,4,5},2)));
    }
}
