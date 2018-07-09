package com.algorithm.study.demo.datastructure.stack;

/**
 *
 * 栈的链式存贮结构,也称为链栈，它是一种限制运算的链表，即规定链表中的插入和删除运算只能在链表开头进行。
 *
 * Created by liuxun on 2017/6/20.
 */
public class LinkStack<T> {
    // 定义一个内部类Node，代表链表的节点
    private class Node {
        private T data;// 保存数据
        private Node next;// 指向下个节点的引用
        // 无参构造器
        public Node() {
        }
        // 初始化全部属性的构造器
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    //栈顶元素
    private Node top;
    //元素个数
    private  int size;

    public LinkStack(){
        this.top=null;//初始化一个空的栈
    }

    /**
     * 入栈，在栈顶的位置插入元素
     * @param element
     */
    public void push(T element){
        top=new Node(element,top);
        size++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if (top==null){
            return null;
        }
        Node temp=top;
        top=temp.next;
        temp.next=null;//释放应用
        size--;
        return temp.data;//返回栈顶元素
    }
    //返回栈顶的元素，但不出栈
    public T peek(){
        return top.data;

    }
    // 判断链栈是否为空栈
    public boolean empty() {
        return size == 0;
    }
    //堆栈长度
    public int length(){
        return  size;
    }

}
