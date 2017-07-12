package com.algorithm.study.demo.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * lambda环绕执行模式
 第1 步：记得行为参数化
 第2 步：使用函数式接口来传递行为
 第3 步：执行一个行为
 第4 步：传递Lambda
 * Created by liuxun on 2017/7/11.
 */
public class hello3 {
    public static void main(String[] args) throws IOException {
        System.out.println(processFile((BufferedReader b)->b.readLine()));
    }
    public static String processFile(BufferedReaderProcessor buff) throws IOException {
        //使用了Java 7 中的带资源的try 语句，它已经简化了代码，因为你不需要显式地关闭资源了
        try (BufferedReader br =
                     new BufferedReader(new FileReader("E:\\count.txt"))) {
            return buff.process(br);
        }

    }
}
