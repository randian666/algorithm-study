package com.algorithm.study.demo.jvm;

/**
 * @author liuxun
 * @version V1.0
 * @Description: VM Args：-verbose:gc -Xss128k -XX:+PrintGCDetails
 * @date 2017/11/28
 */
public class StackSOF {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        StackSOF sof=new StackSOF();
        try {
            sof.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:"+sof.stackLength);
            throw e;
        }
    }
}
