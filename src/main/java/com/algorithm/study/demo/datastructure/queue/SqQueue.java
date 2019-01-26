package com.algorithm.study.demo.datastructure.queue;

/**
 　队列（简称作队，Queue）也是一种特殊的线性表，队列的数据元素以及数据元素间的逻辑关系和线性表完全相同，
 其差别是线性表允许在任意位置插入和删除，而队列只允许在其一端进行插入操作在其另一端进行删除操作。
 队列中允许进行插入操作的一端称为队尾，允许进行删除操作的一端称为队头。队列的插入操作通常称作入队列，队列的删除操作通常称作出队列。

 循环队列可以有效的利用资源。如果使用普通数组实现队列时，如果不进行移动，随着数据的不断读写弹出插入，会出现假满队列的情况。例如不断向队列中添加元素，然后在弹出元素。这是弹出元素所空闲出来的空间并没有得到重复利用，
 这是就会出现数组尾部已经满了，但是头部还有空闲空间没有得到利用。
 入队时尾指针向前追赶头指针，出队时头指针向前追赶尾指针

 * Created by liuxun on 2017/6/22.
 */
public class SqQueue<E> {
    private Object[] data;
    private int front;//头指针
    private int rear;//尾指针
    private int maxsize;//长度

    public SqQueue(int capacity){
        this.maxsize=capacity;
        this.data=new Object[capacity];
        front=rear=0;
    }
    /**返回队列当前长度**/
    public int size(){
        if (isFull()){
            return maxsize;
        }
        return (rear-front+maxsize)%maxsize;
    }

    /**
     * 循环队列入队操作
     * @param element
     */
    public boolean add(E element){
        if ((rear+1)%maxsize==front) return false;//队列已满
        data[rear]=element;
        //逻辑上实现首尾相连，循环队列
        rear=(rear+1)%maxsize;
        return true;
    }
    /**
     * 循环队列出队操作，并清空头部
     * @return
     */
    public Object poll(){
        if (rear==front && data[front]==null){
            return null;
        }
        Object result=data[front];
        data[front]=null;
        front=(front+1)%maxsize;
        return result;
    }
    /**
     * 循环队列出队操作,不清空头部
     * @return
     */
    public Object peek(){
        return data[front];
    }
    //check is null
    private boolean isFull(){
        //首尾相等并且首不为空的话就代表队列已满
        return front == rear && data[front]!=null;
    }

    public static void main(String[] args) {
        SqQueue queue=new SqQueue(8);
        for (int i=0;i<8;i++){
            queue.add(i);
        }
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }

}
