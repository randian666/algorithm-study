package com.algorithm.study.demo.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 当对一个共享变量执行操作时，我们可以使用循
 环CAS的方式来保证原子操作，但是对多个共享变量操作时，循环CAS就无法保证操作的原子
 性，这个时候就可以用锁。还有一个取巧的办法，就是把多个共享变量合并成一个共享变量来
 操作。比如，有两个共享变量i＝2，j=a，合并一下ij=2a，然后用CAS来操作ij。从Java 1.5开始，
 JDK提供了AtomicReference类来保证引用对象之间的原子性，就可以把多个变量放在一个对
 象里来进行CAS操作。
 * Created by liuxun on 2017/6/13.
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();
    public static void main(String[] args) {
        User user = new User("conan", 15);
        atomicUserRef.set(user);
        User updateUser = new User("Shinichi", 17);
        atomicUserRef.compareAndSet(atomicUserRef.get(), updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

    static class User {

        private String name;
        private int old;

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
