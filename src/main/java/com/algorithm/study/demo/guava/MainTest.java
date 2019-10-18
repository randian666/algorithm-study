package com.algorithm.study.demo.guava;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * guava 重试机制
 * @Author: liuxun
 * @CreateDate: 2019/1/2 上午11:29
 * @Version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        //定义重试机制
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException()    //设置异常重试
                .retryIfResult(Predicates.equalTo(true))    //call方法返回true重试
                .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))   //设置10秒后重试
                .withStopStrategy(StopStrategies.stopAfterAttempt(3)).build();  //设置重试次数 超过将出异常
        try {
            retryer.call(() -> {
                //这里写你的业务逻辑代码
                System.out.println("11111111111111111122222");
                return true;   //需要重试返回true
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
    }
}

