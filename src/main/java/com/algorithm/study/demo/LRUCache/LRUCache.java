package com.algorithm.study.demo.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存链表实现思路
 * 每次写入数据时将数据放入链表头结点。
 * 使用数据时候将数据移动到头结点。
 * 缓存数量超过阈值时移除链表尾部数据。
 * @Author: liuxun
 * @CreateDate: 2018/7/12 下午6:05
 * @Version: 1.0
 */
public class LRUCache {
    class Node{
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
        public Node(){}

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    private void moveToHead(Node node){
        remove(node);
        addNode(node);
    }
    //删除尾节点
    private Node popTail(){
        Node prevNode= tail.prev;
        tail.prev=prevNode.prev;
        prevNode.prev.next=tail;

        prevNode.next=null;
        prevNode.prev=null;

        size--;
        return prevNode;
    }
    //删除中间节点
    private void  remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;

        node.next=null;
        node.prev=null;

        size--;
    }
    //添加节点
    private void addNode(Node node){
        node.next=head.next;
        node.prev=head;
        node.next.prev=node;
        head.next=node;
        size++;
    }
    private Map<Integer,Node> cache=new HashMap<Integer,Node>();
    private int size=0;
    private int capacity=0;
    //头结点
    private Node head;
    //尾结点
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        //初始化头尾节点
        this.head=new Node();
        this.tail=new Node();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        //从缓存获取
        Node node=cache.get(key);
        if(null==node){
            return -1;
        }
        //数据移到头结点
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node=cache.get(key);
        if(null==node){
            node=new Node(key,value);
            //写入新节点至头节点
            addNode(node);
            cache.put(key,node);
            //如果容量已满，删除尾节点
            if(size>capacity){
                //删除尾节点
                Node delNode=popTail();
                cache.remove(delNode.key);
            }
        }else{
            //数据更新并移到头结点
            node.value=value;
            moveToHead(node);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        for (Node node = head;node!=null;node=node.next){
                sb.append(node.getKey()).append(":")
                        .append(node.getValue())
                        .append("-->");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LRUCache lruMap=new LRUCache(2);
        lruMap.put(1,1);
        lruMap.put(2,2);
        lruMap.get(1);
        lruMap.put(3,3);
        lruMap.get(2);
        lruMap.put(4,4);
        lruMap.get(1);
        lruMap.get(3);
        lruMap.get(4);
        System.out.println(lruMap.toString());
    }

}
