package com.algorithm.study.demo.thread;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 因为CAS需要在操作值的时候，检查值有没有发生变化，如果没有发生变化
 则更新，但是如果一个值原来是A，变成了B，又变成了A，那么使用CAS进行检查时会发现它
 的值没有发生变化，但是实际上却变化了。ABA问题的解决思路就是使用版本号。在变量前面
 追加上版本号，每次变量更新的时候把版本号加1，那么A→B→A就会变成1A→2B→3A。从
 Java 1.5开始，JDK的Atomic包里提供了一个类AtomicStampedReference来解决ABA问题。这个
 类的compareAndSet方法的作用是首先检查当前引用是否等于预期引用，并且检查当前标志是
 否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定的更新值。
 * Created by liuxun on 2017/6/13.
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(
            19, 0);

    public static void main(String[] args)
    {
        for (int i = 0; i < 3; i++)
        {
            final int timestamp = money.getStamp();
            new Thread()
            {
                public void run()
                {
                    while (true)
                    {
                        while (true)
                        {
                            Integer m = money.getReference();
                            if (m < 20)
                            {
                                if (money.compareAndSet(m, m + 20, timestamp,
                                        timestamp + 1))
                                {
                                    System.out.println("充值成功，余额:"
                                            + money.getReference());
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                };
            }.start();
        }

        new Thread()
        {
            public void run()
            {
                for (int i = 0; i < 100; i++)
                {
                    while (true)
                    {
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10)
                        {
                            if (money.compareAndSet(m, m - 10, timestamp,
                                    timestamp + 1))
                            {
                                System.out.println("消费10元，余额:"
                                        + money.getReference());
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
    }
}
