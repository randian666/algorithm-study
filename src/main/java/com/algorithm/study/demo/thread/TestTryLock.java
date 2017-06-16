package com.algorithm.study.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 假如线程A和线程B使用同一个锁LOCK，此时线程A首先获取到锁LOCK.lock()，并且始终持有不释放。如果此时B要去获取锁，有四种方式：
 LOCK.lock(): 此方式会始终处于等待中，即使调用B.interrupt()也不能中断，除非线程A调用LOCK.unlock()释放锁。
 LOCK.lockInterruptibly(): 此方式会等待，但当调用B.interrupt()会被中断等待，并抛出InterruptedException异常，否则会与lock()一样始终处于等待中，直到线程A释放锁。
 LOCK.tryLock(): 该处不会等待，获取不到锁并直接返回false，去执行下面的逻辑。
 LOCK.tryLock(10, TimeUnit.SECONDS)：该处会在10秒时间内处于等待中，但当调用B.interrupt()会被中断等待，并抛出InterruptedException。10秒时间内如果线程A释放锁，会获取到锁并返回true，否则10秒过后会获取不到锁并返回false，去执行下面的逻辑。

 1、ReentrantLock 拥有Synchronized相同的并发性和内存语义，此外还多了 锁投票，定时锁等候和中断锁等候
 线程A和B都要获取对象O的锁定，假设A获取了对象O锁，B将等待A释放对O的锁定，
 如果使用 synchronized ，如果A不释放，B将一直等下去，不能被中断
 如果 使用ReentrantLock，如果A不释放，可以使B在等待了足够长的时间以后，中断等待，而干别的事情
 2、synchronized是在JVM层面上实现的，不但可以通过一些监控工具监控synchronized的锁定，而且在代码执行时出现异常，JVM会自动释放锁定，但是使用Lock则不行，lock是通过代码实现的，要保证锁定一定会被释放，就必须将unLock()放到finally{}中
 3、在资源竞争不是很激烈的情况下，Synchronized的性能要优于ReetrantLock，但是在资源竞争很激烈的情况下，Synchronized的性能会下降几十倍，但是ReetrantLock的性能能维持常态；
 4、synchronized原始采用的是CPU悲观锁机制，即线程获得的是独占锁。而Lock用的是乐观锁方式。乐观锁实现的机制就是CAS操作（Compare and Swap）。
 * Created by liuxun on 2017/6/12.
 */
public class TestTryLock {
    private List<Object> list = new ArrayList<Object>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final TestTryLock test = new TestTryLock();
        for (int i=0;i<10;i++){
            new Thread("第一个线程"+i+"  ") {

                @Override
                public void run() {
                    test.doSomething(Thread.currentThread());
                }
            }.start();

            new Thread("第二个线程"+i+"  ") {

                @Override
                public void run() {
                    test.doSomething(Thread.currentThread());
                }
            }.start();
        }

    }

    public void doSomething(Thread thread) {
        if (lock.tryLock()) {//如果没获取到锁不会等待、阻塞，继续执行。
            try {
                System.out.println(thread.getName() + "得到了锁.");
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(thread.getName() + "释放了锁.");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + "获取锁失败.");
        }
    }
}
