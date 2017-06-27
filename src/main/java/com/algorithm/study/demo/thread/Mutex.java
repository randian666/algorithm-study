package com.algorithm.study.demo.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 利用同步器实现独占式锁
 * Created by liuxun on 2017/6/27.
 */
public class Mutex implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer{
        //是否处于占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
        //当状态为0的时候获取锁
        @Override
        protected boolean tryRelease(int arg) {
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        //释放锁，将状态设置为0
        @Override
        protected boolean tryAcquire(int arg) {
            if (getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        Condition newCondition(){return new ConditionObject();}
    }
    private final  Sync sync=new Sync();
    //获取锁
    public void lock() {

        sync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }
}
