package com.algorithm.study.demo.algorithm.greedyalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liuxun
 * @title: Solutions
 * @projectName algorithm-study
 * @description: 零钱支付问题
 * 假设我们有 1 元、2 元、5 元、10 元、20 元、50 元、100 元这些面额的纸币，
 * 它们的张数分别是 c1、c2、c5、c10、c20、c50、c100。
 * 我们现在要用这些钱来支付 K 元，最少要用多少张纸币呢？
 * 先用面值最大的来支付，如果不够，就继续用更小一点面值的，以此类推，最后剩下的用 1 元来补齐。
 * @date 2019/11/14 17:20
 */
public class Solutions {
    /**
     * 用于存储金额的信息,根据金额从大到小排序
     */
    public PriorityQueue<MoneyBusi> moneyQueue =
            new PriorityQueue<>(
                    (o1, o2) -> {
                        if (o1.getMemory() < o2.getMemory()) {
                            return 1;
                        } else if (o1.getMemory() > o2.getMemory()) {
                            return -1;
                        }
                        return 0;
                    });

    /**
     * 添加金额信息
     * @param value  面值信息
     * @param num    张数
     * @param memory 金额值
     */
    public void addMemoryInfo(String value, int num, int memory) {
        moneyQueue.offer(new MoneyBusi(value, num, memory));
    }

    /**
     * 计算找零钱的问题
     *
     * @param money 找零的金额信息
     * @return 找零钱的信息
     */
    public List<MoneyBusi> looseChange(int money) {

        List<MoneyBusi> resultMemory = new ArrayList<>();

        List<MoneyBusi> moreMemory = new ArrayList<>();

        int surplus = money;

        while (surplus > 0) {
            //返回队列头部元素
            MoneyBusi busi = moneyQueue.peek();
            if (null != busi) {
                System.out.println("当前金额："+busi.getMemory());
                if (busi.getMemory() <= surplus) {
                    busi = moneyQueue.poll();
                    surplus = surplus - busi.getMemory();

                    MoneyBusi busiNew = new MoneyBusi(busi.getValue(), 1, busi.getMemory());
                    resultMemory.add(busiNew);

                    busi.setNum(busi.getNum() - 1);

                    if (busi.getNum() > 0) {
                        moneyQueue.offer(busi);
                    }
                } else {
                    moreMemory.add(moneyQueue.poll());
                }
            } else {
                break;
            }
        }
        moneyQueue.addAll(moreMemory);
        return resultMemory;
    }

    public static void main(String[] args) {
        Solutions instance = new Solutions();
        instance.addMemoryInfo("100元", 2, 100);
        instance.addMemoryInfo("50元", 2, 50);
        instance.addMemoryInfo("20元", 2, 20);
        instance.addMemoryInfo("10元", 2, 10);
        instance.addMemoryInfo("5元", 2, 5);
        instance.addMemoryInfo("2元", 2, 2);
        instance.addMemoryInfo("1元", 5, 1);
        System.out.println(instance.moneyQueue);
        List<MoneyBusi> list = instance.looseChange(332);
        for (MoneyBusi busi : list) {
            System.out.println(busi);
        }
    }
}
