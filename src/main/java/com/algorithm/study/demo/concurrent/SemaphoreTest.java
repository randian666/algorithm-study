package com.algorithm.study.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 Semaphore可以用于做流量控制，特别是公用资源有限的应用场景，比如数据库连接。假
 如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，我们可以启动几十个线程
 并发地读取，但是如果读到内存后，还需要存储到数据库中，而数据库的连接数只有10个，这
 时我们必须控制只有10个线程同时获取数据库连接保存数据，否则会报错无法获取数据库连
 接。这个时候，就可以使用Semaphore来做流量控制
 * Created by liuxun on 2017/6/28.
 */
public class SemaphoreTest {
    static ExecutorService executorService= Executors.newFixedThreadPool(10);
    static Semaphore semaphore=new Semaphore(2);

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("保存数据中"+Thread.currentThread());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
//            executorService.shutdown();
        }
    }
}
