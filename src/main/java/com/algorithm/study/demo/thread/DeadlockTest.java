package com.algorithm.study.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去
 * 避免死锁：一种是加锁顺序（线程按照一定的顺序加锁）；另一种是加锁时限（线程尝试获取锁的时候加上一定的时限，超过时限则放弃对该锁的请求，并释放自己占有的锁）；
 */
public class DeadlockTest {
    private static Object o1=new Object();
    private static Object o2=new Object();
    public static void main(String[] args) {
          new Thread(()->{
                  synchronized (o1){
                      System.out.println("Thread1 get lock o1");
                      try {
                          TimeUnit.SECONDS.sleep(1);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      synchronized (o2){
                          System.out.println("Thread1 get lock o2");
                      }
                      System.out.println("Thread1 end");
                  }
          }).start();

        new Thread(() -> {
            synchronized (o2){
                System.out.println("Thread2 get lock o1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("Thread2 get lock o2");
                }
                System.out.println("Thread2 end");
            }
        }).start();
    }
}
