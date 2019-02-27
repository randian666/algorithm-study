package com.algorithm.study.demo;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/23 下午3:21
 * @Version: 1.0
 */
public class RandomLoadBalance extends  AbstractLoadBalance{
    @Override
    protected String doSelect(String name) {
        System.out.println("doSelect run name is "+ name);
        return name;
    }
}
