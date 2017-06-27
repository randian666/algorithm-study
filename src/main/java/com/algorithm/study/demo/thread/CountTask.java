package com.algorithm.study.demo.thread;

import java.util.concurrent.*;

/**
 * Fork/Join框架是Java 7提供的一个用于并行执行任务的框架，是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。
 *步骤1　分割任务。首先我们需要有一个fork类来把大任务分割成子任务，有可能子任务还是很大，所以还需要不停地分割，直到分割出的子任务足够小。
  步骤2　执行任务并合并结果。分割的子任务分别放在双端队列里，然后几个启动线程分别从双端队列里获取任务执行。子任务执行完的结果都统一放在一个队列里，启动一个线程从队列里拿数据，然后合并这些数据。

 * Created by liuxun on 2017/6/27.
 */
public class CountTask extends RecursiveTask<Integer>{
    private final static int THRESHOLD=2;//阈值
    private int start;
    private int end;
    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOLD;
        if (canCompute){
            for (int i=start;i<=end;i++){
                sum+=i;
            }
        }else{
            int middle=(start+end)/2;//分成两个子任务执行
            CountTask task1=new CountTask(start,middle);
            CountTask task2=new CountTask(middle+1,end);
            //执行子任务
            task1.fork();
            task2.fork();
            //等待任务执行完，并得到其结果
            int num1=task1.join();
            int num2=task2.join();
            sum=num1+num2;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        // 生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(1, 4);
        // 执行一个任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }
}
