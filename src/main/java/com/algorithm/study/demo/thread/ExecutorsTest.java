package com.algorithm.study.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的用法
 * Created by LiuXun on 2017/7/1.
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorsTest.newScheduledThreadPoolTest();
    }

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     * CachedThreadPool使用没有容量的SynchronousQueue作为线程池的工作队列
     * */
    public static void newCachedThreadPoolTest(){
        ExecutorService cachedThreadPool=Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    /**
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     * 产生一个 ExecutorService 对象，这个对象带有一个大小为 poolSize 的线程池，若任务数量大于 poolSize ，任务会被放在一个 LinkedBlockingQueue 里顺序执行。
     */
    public static void newFixedThreadPoolTest(){
        ExecutorService fixedThreadPool=Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);//每隔二秒执行三个线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序
     * 产生一个 ExecutorService 对象，这个对象带有一个大小为 1 的线程池，若任务数量大于 poolSize ，任务会被放在一个 LinkedBlockingQueue 里顺序执行。
     */
    public static void newSingleThreadExecutorTest(){
        ExecutorService singleThreadExecutor=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行。
     *1）当调用ScheduledThreadPoolExecutor的scheduleAtFixedRate()方法或者scheduleW
     FixedDelay()方法时，会向ScheduledThreadPoolExecutor的DelayQueue添加一个实现了
     RunnableScheduledFutur接口的ScheduledFutureTask。
     2）线程池中的线程从DelayQueue中获取ScheduledFutureTask，然后执行任务。

     DelayQueue封装了一个PriorityQueue，这个PriorityQueue会对队列中的Scheduled-
     FutureTask进行排序。排序时，time小的排在前面（时间早的任务将被先执行）。如果两个
     ScheduledFutureTask的time相同，就比较sequenceNumber，sequenceNumber小的排在前面（也就
     是说，如果两个任务的执行时间相同，那么先提交的任务将被先执行）。
     */
    public static void newScheduledThreadPoolTest(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        //表示三秒后延迟执行
        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        },3, TimeUnit.SECONDS);
        //表示三秒后延迟执行，然后每隔一秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds do scheduleAtFixedRate, and excute every 1 seconds");
            }
        },3,1,TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds do scheduleWithFixedDelay , and excute every 1 seconds");
            }
        },3,1,TimeUnit.SECONDS);
    }
}
