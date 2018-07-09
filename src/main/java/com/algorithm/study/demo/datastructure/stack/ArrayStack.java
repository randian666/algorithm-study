package com.algorithm.study.demo.datastructure.stack;


/**
 * 栈的顺序存储结构实现
 * 只能从一端进行插入、删除操作的特殊线性表，通常情况下在栈的尾巴进行插入、删除操作。
 * 对于栈而言，允许插入和删除操作的是栈顶(top)，另一端是栈底(bottom)。一个栈不包含任何元素的时候是一个空栈。从栈顶插入一个元素是进栈，
 * 将一个元素插入栈顶被称为“压入栈”----对应于英文(push)。从栈顶删除一个元素被称为出栈，将一个元素从栈顶删除被称为“弹出栈”----对应于英文(pop)
 * 栈来自与线性表，因此栈可以使用顺序表的方式来实现也可以使用链表的方式来实现。
 * Created by liuxun on 2017/6/20.
 */
public class ArrayStack<E> {
    private Object[] data;//数组存储数据元素
    //栈默认长度，存放线性表的存储空间长度
    private final static int DEFAULT_CAPACITY=16;
    //数据元素的个数，也是栈顶的指针
    private int size=0;

    public ArrayStack(int capacity){
        this.data=new Object[Math.abs(capacity)];
    }
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 入栈，在栈顶的位置插入元素，如果栈的容量已经满了，需要先扩容
     * @param element 数据元素
     * @return
     */
    public boolean push(E element){
        /*栈满*/
        if (size==data.length){//如果数组已经满了需要扩容。
            Object[] temp=data;
            data=new Object[data.length+(data.length/2)];
            System.arraycopy(temp,0,data,0,temp.length);
        }
        data[size]=element;//数组的末尾插入元素
        size++;
        return true;
    }
    /**
     * 出栈，从栈顶的位置删除并返回当前元素。
     * @return
     */
    public Object pop(){
        if (size==0){
            throw new RuntimeException("空栈，size:"+size);
        }
        Object result = data[size-1];
        data[size-1]=null;
        size--;
        return result;
    }
    //返回栈顶的元素，但不出栈
    public Object peek(){
        return data[size-1];

    }
    //获取栈的大小
    public int getLength()
    {
        return size;
    }
}
