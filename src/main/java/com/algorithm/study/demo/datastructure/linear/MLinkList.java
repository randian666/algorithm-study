package com.algorithm.study.demo.datastructure.linear;

import java.util.Stack;

/**
 * 线性表的链式存储-单链表的实现
 * 单链表采用链式存储结构，用一组任意的存储单元存放线性表元素
 * 单链表不需要分配存储空间，元素个数也受限制
 * 若线性表需要频繁查找，很少进行插入和删除操作时，宜采用顺序存储结构，若需要频繁插入和删除时，宜采用单链表结构。
 * 当线性表的元素个数变化较大或者根本不知道有多大时，最好用单链表结构。这样可以不需要考虑存储空间的大小问题。
 * Created by liuxun on 2017/6/16.
 */
public class MLinkList<E> {
    // 定义一个内部类Node，代表链表的节点
    public class Node {
        private E value;// 保存数据
        private Node next;// 指向下个节点的引用

        // 无参构造器
        public Node() {
        }
        // 初始化全部属性的构造器
        public Node(E data, Node next) {
            this.value = data;
            this.next = next;
        }
    }
    private Node data;// 保存头结点
    private int size=0;// 保存已含有的节点数

    public MLinkList(){
        this.data=null;//初始化一个空的头结点
    }

    /**
     * 添加一个头结点
     * @param element
     */
    public void addFirst(E element){
        if (data==null){
            data=new Node(element,null);
        }else{
            Node temp=new Node(element,null);
            temp.next=data;
            data=temp;
        }
        size++;
    }
    /**
     * 删除一个头结点
     * @return
     */
    public E deleteFirst(){
        Node current=data;
        E val=current.value;
        current.value=current.next.value;
        current.next=current.next.next;
        return val;
    }

    /**
     * 在index插入节点
     * @param index
     * @param element
     */
    public void add(int index,E element){
        checkPositionIndex(index);
        if (index==0){
            addFirst(element);
            return;
        }
        Node newNode=new Node(element,null);//新的结点
        Node current=data;//保存index当前的结点
        int i=1;//默认是第i个结点
        while (i<index){//寻找第i个结点
            current=current.next;
            i++;
        }
        newNode.next=current.next;
        current.next=newNode;
        size++;
    }

    /**
     * 把index结点设置成新的值
     * @param inddex
     * @param element
     */
    public void set(int inddex,E element){
        checkPositionIndex(inddex);
        Node current=data;//保存index当前的结点
        int j=0;
        while (j!=inddex){//找到第j个结点
            current=current.next;
            j++;
        }
        current.value=element;
    }
    /**
     * 增加一个末尾结点
     * @param element
     */
    public void add(E element){
        if (size==0){
            addFirst(element);
            return;
        }
        Node newNode=new Node(element,null);//新的结点
        Node temp=data;
        int j=1;
        while (j<size){
            temp= temp.next;//找到最后一个结点
            j++;
        }
        temp.next=newNode;
        size++;
    }
    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public E get(int index){
       checkPositionIndex(index);
       Node temp=data;//从头结点开始遍历
        int j=0;
        while(j<index){
            temp=temp.next;
            j++;
        }
        return temp.value;
    }

    /**
     * 删除index结点
     * @param index
     */
    public void delete(int index){
        checkPositionIndex(index);
        if (index==0){
            deleteFirst();
        }else{
            Node current=data;
            int j=1;
            while (j<index){//找到第j个结点
                current=current.next;
                j++;
            }
            current.value=current.next.value;
            current.next=current.next.next;
        }
        size--;
    }

    /**
     * 删除元素
     * @param element
     */
    public void delete(E element){
        Node temp=data;
        while (!temp.value.equals(element)){
            if (temp.next==null){
                return;
            }
            temp=temp.next;
        }
        temp.value=temp.next.value;
        temp.next=temp.next.next;
        size--;
    }
    public void clear(){
        data=null;
        size=0;
    }
    private void checkPositionIndex(int index) {
        if (index<0 || index>size-1){
            throw new IndexOutOfBoundsException("数组越界Index: "+index+", Size: "+size);
        }
    }
    public int size(){
        return size;
    }


    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        Node temp=data;
        while (temp!=null){
            sb.append(temp.value);
            temp= temp.next;//找到最后一个结点
        }
        return sb.toString();
    }

    /**
     * 反转链表O(n)复杂度实现
     */
    public void reverseLinkedList(){
        if (data==null || data.next==null){
            return;
        }
        Node p1=data;
        Node p2=data.next;
        Node p3=null;
        while (p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        data.next=null;
        data=p1;
        System.out.println("反转完毕");
    }

    public static void main(String[] args) {
        MLinkList<Integer> mLinkList=new MLinkList();
        mLinkList.add(4);
        mLinkList.add(1);
        mLinkList.add(8);
        mLinkList.add(4);
        mLinkList.add(5);
//        System.out.println(mLinkList.toString());
//        mLinkList.delete("b");
//        mLinkList.delete(0);
//        System.out.println(mLinkList.size);
//        mLinkList.reverseLinkedList();
        System.out.println(mLinkList.toString());

    }

}
