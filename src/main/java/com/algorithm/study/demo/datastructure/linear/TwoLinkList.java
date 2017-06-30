package com.algorithm.study.demo.datastructure.linear;

/**
 * 双向链表实现
 * Created by liuxun on 2017/6/19.
 */
public class TwoLinkList<E> {

    private class Node<E> {
       private Node prev;//上一节点
       private E element;//节点元素
       private Node next;//下一节点

        // 无参构造器
        public Node() {
        }
        // 初始化全部属性的构造器
        public Node(Node prev,E element, Node next) {
            this.prev=prev;
            this.element = element;
            this.next = next;
        }
    }
    private Node first;// 保存头结点
    private Node last;//末节点
    private int size=0;// 保存已含有的节点数

    public TwoLinkList(){
        this.first=null;//初始化一个空的头结点
        this.last=null;//初始化一个空的尾结点
    }
    /**
     * 添加一个头结点
     * @param element
     */
    public void addFirst(E element){
        Node temp=new Node(null,element,null);
        if (first == null) {
            last = temp;
        }else{
            first.prev=temp;
            temp.next=first;
        }
        first=temp;
        size++;
    }
    /**
     * 增加一个末尾结点
     * @param element
     */
    public void addLast(E element){
        Node temp=new Node(null,element,null);
        if (first == null) {
            first = temp;
        }else{
            last.next=temp;
            temp.prev=last;
        }
        last=temp;
        size++;
    }
    public void set(int index,E element){
        Node temp=first;
        int i=0;
        while (i<index){
            temp=temp.next;
            i++;
        }
        temp.element=element;
    }
    public void add(E element){
        this.addLast(element);
    }
    /**
     * 删除一个头结点
     * @return
     */
    public Object deleteFirst(){
        Node temp=first;
        if (first.next==null){
            last=null;
        }else{
            temp.next.prev=null;
        }
        first=temp.next;
        size--;
        return temp.element;
    }

    /**
     * 删除最后一个结点
     * @return
     */
    public Object deleteLast(){
        Node temp=last;
        if (first.next==null){
            last=null;
        }else{
            temp.prev.next=null;
        }
        last=temp.prev;
        size--;
        return temp.element;
    }
    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public Object get(int index){
        checkPositionIndex(index);
        Node temp=first;
        int j=0;
        while (j!=index){
            temp=temp.next;
            j++;
        }
        return temp.element;
    }
    /**
     * 获取头元素
     * @return
     */
    public Object getFirst(){
        if (first==null){
            return null;
        }
        return first.element;
    }

    /**
     * 获取尾元素
     * @return
     */
    public Object getLast(){
        if (last==null){
            return null;
        }
        return last.element;
    }
    private void checkPositionIndex(int index) {
        if (index<0 || index>size-1)
            throw new IndexOutOfBoundsException("数组越界Index: "+index+", Size: "+size);
    }
    public int size(){
        return size;
    }
}
