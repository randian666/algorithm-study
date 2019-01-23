package com.algorithm.study.demo.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 单链表实现LRU缓存
 * @Author: liuxun
 * @CreateDate: 2019/1/23 下午4:03
 * @Version: 1.0
 */
public class LRULinked<K,V>{
    private final Map<K, V> cacheMap = new HashMap<>();

    private Node<K, V> root;
    private int cacheSize;
    private int size;
    public LRULinked(int cacheSize){
        this.cacheSize=cacheSize;
    }

    /**
     * 插入头结点
     * @param value
     */
    public void put(K key,V value){
        Node<K, V> node=new Node<K, V>(key,value);
        if (size==cacheSize){//容量满了删除尾节点
            Node<K, V> temp=root.next;
            if (temp==null){
                root=null;
                size--;
            }else{
                Node<K, V> current=root;
                while (temp.next!=null){
                    current=temp;
                    temp=temp.next;
                }
                current.next=null;
                size--;
            }
        }
        node.next=root;
        root=node;
        size++;
    }
    public V get(K key){
        for (Node<K,V> node = root; node!=null; node=node.next){
            if (node.next.key.equals(key)){
                Node<K, V> nodeNew=new Node<K, V>(node.next.key,node.next.value);
                node.next=node.next.next;
                size--;
                this.put(nodeNew.key,nodeNew.value);//查找的节点放到头结点
                break;
            }
        }
        return cacheMap.get(key);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        int j=0;
        Node<K, V> temp=root;
        while (j<size){
            sb.append(temp.value);
            temp= temp.next;//找到最后一个结点
            j++;
        }
        return sb.toString();
    }

    public static class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;
        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    public static void main(String[] args) {
        LRULinked<String,String> linked=new LRULinked<>(3);
        linked.put("a","a");
        linked.put("b","b");
        linked.put("c","c");
        linked.get("a");
        linked.put("d","d");
        System.out.println(linked.size);
        System.out.println(linked.toString());
        System.out.println(linked.toString());
        System.out.println(linked.size);



    }
}
