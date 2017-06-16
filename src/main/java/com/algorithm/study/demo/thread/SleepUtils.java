package com.algorithm.study.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuxun on 2017/6/15.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
