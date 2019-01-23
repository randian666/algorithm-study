package com.algorithm.study.demo.jike;

import java.util.Stack;

/**
 * 如果字符串是通过单链表来存储的，那该如何来判断是一个回文串
 * @Author: liuxun
 * @CreateDate: 2019/1/23 下午6:16
 * @Version: 1.0
 */
public class Linked_6 {
    private Node root;
    private int size;
    /**
     * 插入头结点
     * @param value
     */
    public void put(String value){
        Node node=new Node(value);
        if (root==null){
            root=node;
            size++;
            return;
        }
        int i=1;
        Node temp=root;
        while (i<size){
            temp=temp.next;
            i++;
        }
        temp.next=node;
        size++;
    }
    public static class Node{
        private String value;
        private Node next;
        public Node(String value){
            this.value=value;
        }
    }

    public boolean isPalindrome() {
        if (root == null)
            return false;
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = root;
        while (p != null) {
            if (p.value != stack.pop().value)
                return false;
            p = p.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Linked_6 linked=new Linked_6();
        linked.put("a");
        linked.put("b");
        linked.put("c");
        System.out.println("是否是回文字符串"+linked.isPalindrome());
    }
}
