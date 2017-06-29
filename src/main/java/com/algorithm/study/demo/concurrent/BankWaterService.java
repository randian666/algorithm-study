package com.algorithm.study.demo.concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by liuxun on 2017/6/27.
 */
public class BankWaterService{
    /**
     * 创建四个屏障，处理完之后执行handler的run方法
     */
    private CyclicBarrier c=new CyclicBarrier(4,new handler());

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount=new ConcurrentHashMap<String,Integer>();
    /**
     * 开启四个个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);
    class handler implements Runnable{
        public void run() {
            int result = 0;
            // 汇总每个sheet计算出的结果
            for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
                result += sheet.getValue();
                System.out.println(sheet.getKey()+":"+sheet.getValue());
            }
            // 将结果输出
            sheetBankWaterCount.put("result", result);
            System.out.println(result);
        }
    }
    private void count() {
        for (int i = 0; i< 4; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    // 计算当前sheet的银流数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 银流计算完成，插入一个屏障
                    try {
                        c.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public static void main(String[] args) {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
    }
}
