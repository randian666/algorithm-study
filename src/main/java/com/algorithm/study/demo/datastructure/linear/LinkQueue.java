package com.algorithm.study.demo.datastructure.linear;

/**
 * 链表式队列
 * Created by liuxun on 2017/6/22.
 */
public class LinkQueue<E> {
    // 定义一个内部类Node，代表链表的节点
    private class Node {
        private E data;// 保存数据
        private Node next;// 指向下个节点的引用

        // 无参构造器
        public Node() {
        }
        // 初始化全部属性的构造器
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;//头结点
    private Node last;//尾结点
    private int size;
    //设置初始化长度
    private final int capacity;
    //默认长度
    public LinkQueue(){
        this(Integer.MAX_VALUE);
    }
    public LinkQueue(int capacity){
            this.capacity=capacity;
            head=last=null;
    }
    public int size(){
        return size;
    }
    public void add(E element){
        if (size==capacity){
            throw new RuntimeException("队列已满，size:"+size());
        }
        Node node=new Node(element,null);
        if (head==null){
            last=head=node;
        }else{
            last=last.next=node;//尾部的下一个指针尾node,并设置新的尾部
        }
        size++;
    }
    public Object poll(){
        if (head==null){
            return null;
        }
        Node node=head;
        head=node.next;
        if (last==node){//如果首尾相等话的释放尾
            last=head;
        }
        node.next=null;
        size--;
        return node.data;
    }
}
