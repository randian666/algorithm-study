package com.algorithm.study.demo.LinearTable;

/**
 * 线性表的链式存储-单链表的实现
 * Created by liuxun on 2017/6/16.
 */
public class MLinkList<E> {
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
    private Node data;// 保存头结点
//    private Node last;// 保存尾结点
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
        Node temp=data;
        data=temp.next;
        size--;
        return temp.data;
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
        Node after=data;//保存index之后的结点
        Node current=data;//保存index当前的结点
        int i=0;//从第一个结点开始遍历
        while (i!=index){//遍历index之前的结点
            current=after;
            after=after.next;
            i++;
        }
        newNode.next=after;
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
        while (j!=inddex){
            current=current.next;
            j++;
        }
        current.data=element;
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
        int j=0;
        while (j<(size-1)){
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
        return temp.data;
    }

    /**
     * 删除index结点
     * @param index
     */
    public void delete(int index){
        checkPositionIndex(index);
        Node temp=data;
        Node current=data;
        int j=0;
        while (j<index){
            current=temp;
            temp=temp.next;
            j++;
        }
        if (temp==data){
            data=data.next;
        }else{
            current.next=temp.next;
        }
        size--;
    }

    /**
     * 删除元素
     * @param element
     */
    public void delete(E element){
        Node temp=data;
        Node current=data;
        while (!temp.data.equals(element)){
            if (temp.next==null){
                return;
            }
            current=temp;
            temp=temp.next;
        }
        if (temp==data){
            data=data.next;
        }else{
            current.next=temp.next;
        }
        size--;
    }
    public void clear(){
        data=null;
        size=0;
    }
    private void checkPositionIndex(int index) {
        if (index<0 || index>size-1)
            throw new IndexOutOfBoundsException("数组越界Index: "+index+", Size: "+size);
    }
    public int size(){
        return size;
    }

}
