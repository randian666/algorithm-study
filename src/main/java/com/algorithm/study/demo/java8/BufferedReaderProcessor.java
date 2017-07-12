package com.algorithm.study.demo.java8;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * BufferedReader函数式接口
 * Created by liuxun on 2017/7/11.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader buff)throws IOException;
}
