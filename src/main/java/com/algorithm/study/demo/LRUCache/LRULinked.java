package com.algorithm.study.demo.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 单链表实现LRU缓存
 * @Author: liuxun
 * @CreateDate: 2019/1/23 下午4:03
 * @Version: 1.0
 */
public class LRULinked{
    //缓存
    private final Map<Integer, Integer> cacheMap = new HashMap<>();
    //根节点
    private Node root;
    private int cacheSize;
    private int size;
    public LRULinked(int cacheSize){
        this.cacheSize=cacheSize;
    }
    /**
     * 插入头结点
     * @param value
     */
    public void put(int key,int value){
        cacheMap.put(key,value);
        Node node=new Node(key,value);
        if (size==cacheSize){//容量满了删除尾节点
            Node temp=root.next;
            if (temp==null){
                root=null;
            }else{
                Node current=root;
                while (temp.next!=null){
                    current=temp;
                    temp=temp.next;
                }
                current.next=null;
            }
            size--;
        }
        node.next=root;
        root=node;
        size++;
    }
    public int get(int key){
        if (!cacheMap.containsKey(key)){
            return -1;
        }
        for (Node node = root; node!=null&&!root.key.equals(key); node=node.next){
            if (node.next.key.equals(key)){
                Node nodeNew=new Node(node.next.key,node.next.value);
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
        for (Node temp=root;temp!=null;temp=temp.next){
            sb.append(temp.value);
        }
        return sb.toString();
    }
    class Node{
        private Integer key;
        private Integer value;
        private Node next;
        public Node(Integer key, Integer value){
            this.key=key;
            this.value=value;
        }
    }

    public static void main(String[] args) {
        LRULinked linked=new LRULinked(3);
        linked.put(1,2);
        linked.put(2,2);
        linked.put(3,3);
        System.out.println(linked.get(1));
        linked.put(4,4);
        System.out.println(linked.size);
        System.out.println(linked.toString());
    }
}
