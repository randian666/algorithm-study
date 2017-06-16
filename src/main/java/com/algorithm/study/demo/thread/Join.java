package com.algorithm.study.demo.thread;

/**
 * 如果一个线程A执行了thread.join()语句，其含义是：当前线程A等待thread线程终止之后才
 从thread.join()返回。线程Thread除了提供join()方法之外，还提供了join(long millis)和join(long
 millis,int nanos)两个具备超时特性的方法。这两个超时方法表示，如果线程thread在给定的超时
 时间里没有终止，那么将会从该超时方法中返回。
 * Created by liuxun on 2017/6/16.
 */
public class Join {
    /**
     * 创建了10个线程，编号0~9，每个线程调用前一个线程的,join()方法，也就是线程0结束了，线程1才能从join()方法中返回，而线程0需要等待main线程结束。
     * 每个线程终止的前提是前驱线程的终止，每个线程等待前驱线程终止后，才从join()方法返回，这里涉及了等待/通知机制（等待前驱线程结束，接收前驱线程结束通知）。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread current = Thread.currentThread();
        for (int i=0;i<10;i++){
            Thread t=new Thread(new JoinTest(current),String.valueOf(i));
            t.start();
            current=t;
        }
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
    static class JoinTest implements Runnable{
        private  Thread current;
        public JoinTest(Thread current){
            this.current=current;
        }
        public void run() {
            try {
                current.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }

}
