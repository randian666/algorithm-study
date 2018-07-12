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
public class LRUMap<K,V> {
    private final Map<K, V> cacheMap = new HashMap<>();
    /**
     * 最大缓存大小
     */
    private int cacheSize;
    /**
     * 节点大小
     */
    private int nodeCount;
    /**
     * 头结点
     */
    private Node<K, V> header;
    /**
     * 尾结点
     */
    private Node<K, V> tailer;
    public LRUMap(int cacheSize) {
        this.cacheSize = cacheSize;
        this.header=null;
        this.tailer=null;
    }
    public void put(K key, V value) {
        cacheMap.put(key, value);
        //双向链表中添加结点
        addNode(key, value);
    }
    public V get(K key){
        Node<K, V> node = getNode(key);
        //移动到头结点
        moveToHead(node) ;
        return cacheMap.get(key);
    }
    private void moveToHead(Node<K,V> node){
        //如果是最后的一个节点
        if (node.next == null){
            node.tail.next=null;
            tailer=node.tail;
            nodeCount -- ;
        }
        //如果是本来就是头节点 不作处理
        if (node.tail == null){
            return ;
        }
        //如果处于中间节点
        if (node.tail != null && node.next != null){
            //它的上一节点指向它的下一节点 也就删除当前节点
            node.tail.next=node.next;
            nodeCount -- ;
        }
        //最后在头部增加当前节点
        //注意这里需要重新 new 一个对象，不然原本的node 还有着下面的引用，会造成内存溢出。
        node = new Node<>(node.getKey(),node.getValue()) ;
        addHead(node) ;
    }
    /**
     * 链表查询 效率较低
     * @param key
     * @return
     */
    private Node<K,V> getNode(K key){
        Node<K,V> node = header ;
        while (node != null){
            if (node.getKey().equals(key)){
                return node ;
            }
            node = node.next ;
        }
        return null ;
    }
    /**
     * 写入头结点
     * @param key
     * @param value
     */
    private void addNode(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        //容量满了删除最后一个
        if (cacheSize == nodeCount) {
            //删除尾结点
            delTail();
        }
        //写入头结点
        addHead(node);
    }
    /**
     * 添加头结点
     *
     * @param node
     */
    private void addHead(Node<K, V> node) {
        if (header==null){
            tailer=node;
        }else{
            header.tail=node;
            node.next=header;
        }
        header=node;
        nodeCount++;
    }
    private void delTail() {
        //把尾结点从缓存中删除
        cacheMap.remove(tailer.getKey());
        tailer.tail.next=null;
        tailer=tailer.tail;
        nodeCount--;
    }
    private class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> tail;
        Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Node() {
        }
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder() ;
        Node<K,V> node = header ;
        while (node != null){
            if (node.getKey()!=null){
                sb.append(node.getKey()).append(":")
                        .append(node.getValue())
                        .append("-->");
            }
            node = node.next ;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LRUMap<String,String> lruMap=new LRUMap<>(3);
        lruMap.put("1","1");
        lruMap.put("2","2");
        lruMap.put("3","3");
        lruMap.get("1");
        lruMap.put("4","4");
        System.out.println(lruMap.toString());
    }

}
