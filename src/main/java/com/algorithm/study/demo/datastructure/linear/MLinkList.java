package com.algorithm.study.demo.datastructure.linear;

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
        temp.next=null;//释放应用
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
        return temp.data;
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
            Node current,temp;
            current=data;
            int j=1;
            while (j<index){//找到第j个结点
                current=current.next;
                j++;
            }
            temp=current.next;
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
