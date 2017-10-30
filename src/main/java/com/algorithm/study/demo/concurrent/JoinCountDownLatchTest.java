package com.algorithm.study.demo.concurrent;

import java.util.concurrent.*;

/**
 * CountDownLatch允许一个或多个线程等待其他线程完成操作。
 * CountDownLatch的构造函数接收一个int类型的参数作为计数器，如果你想等待N个点完成，这里就传入N。
 * 当我们调用CountDownLatch的countDown方法时，N就会减1，CountDownLatch的a
 * 会阻塞当前线程，直到N变成零。由于countDown方法可以用在任何地方，所以这里说
 * 点，可以是N个线程，也可以是1个线程里的N个执行步骤。用在多个线程时，只需要把
 * CountDownLatch的引用传递到线程里即可。
 * Created by liuxun on 2017/6/27.
 */
public class JoinCountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);
    static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws InterruptedException {
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1");
                c.countDown();
            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
                c.countDown();
            }
        });
        c.await();
        System.out.println(3);
    }
}
