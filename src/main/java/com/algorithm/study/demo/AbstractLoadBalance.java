package com.algorithm.study.demo;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/23 下午3:20
 * @Version: 1.0
 */
public abstract class AbstractLoadBalance {
    public String select(String name){
        String newName="hello "+name;
        doSelect(newName);
        return newName;
    }
    protected abstract String doSelect(String name);
}
