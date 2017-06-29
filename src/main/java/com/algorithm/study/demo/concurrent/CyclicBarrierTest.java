package com.algorithm.study.demo.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一
 * 组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会
 * 开门，所有被屏障拦截的线程才会继续运行。
 *
 * CyclicBarrier和CountDownLatch的区别
 *CountDownLatch的计数器只能使用一次，而CyclicBarrier的计数器可以使用reset()方法重
 置。所以CyclicBarrier能处理更为复杂的业务场景。例如，如果计算发生错误，可以重置计数
 器，并让线程重新执行一次。
 CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得Cyclic-Barrier
 阻塞的线程数量。isBroken()方法用来了解阻塞的线程是否被中断。
 CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行。
 CyclicBarrier  : N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。

 CountDownLatch 是计数器, 线程完成一个就记一个, 就像 报数一样, 只不过是递减的.
 而CyclicBarrier更像一个水闸, 线程执行就想水流, 在水闸处都会堵住, 等到水满(线程到齐)了, 才开始泄流.
 *
 *
 *
 * Created by liuxun on 2017/6/27.
 */
public class CyclicBarrierTest {
    static CyclicBarrier c=new CyclicBarrier(3);
    static ExecutorService executorService= Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("1");
            }
        });
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        });
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }
}
