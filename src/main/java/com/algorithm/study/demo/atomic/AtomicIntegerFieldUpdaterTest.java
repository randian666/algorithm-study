package com.algorithm.study.demo.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 如果我们只需要某个类里的某个字段，那么就需要使用原子更新字段类，Atomic包提供了以下三个类：
 AtomicIntegerFieldUpdater：原子更新整型的字段的更新器。
 AtomicLongFieldUpdater：原子更新长整型字段的更新器。
 AtomicStampedReference：原子更新带有版本号的引用类型。该类将整数值与引用关联起来，可用于原子的更数据和数据的版本号，可以解决使用CAS进行原子更新时，可能出现的ABA问题。
 原子更新字段类都是抽象类，每次使用都时候必须使用静态方法newUpdater创建一个更新器。原子更新类的字段的必须使用public volatile修饰符。
 * Created by liuxun on 2017/6/13.
 */
public class AtomicIntegerFieldUpdaterTest {
    public static AtomicIntegerFieldUpdater<User> atomicUserRef =AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        User user = new User("conan", 15);
        atomicUserRef.set(user,15);
        atomicUserRef.compareAndSet(user,user.getOld(),17);
        System.out.println(atomicUserRef.get(user));
        System.out.println(atomicUserRef.getAndIncrement(user));
        System.out.println(atomicUserRef.get(user));
    }

    static class User {

        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }
    }
}
