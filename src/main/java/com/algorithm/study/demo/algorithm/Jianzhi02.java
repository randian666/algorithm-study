package com.algorithm.study.demo.algorithm;

import java.util.Stack;

/**
 *
 * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
 *
 **/

public class Jianzhi02 {

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int e, ListNode next){
            this.val=e;
            this.next=next;
        }
    }
    private  int size=0;// 保存已含有的节点数
    private  ListNode root;
    public  void addFirst(int e){
        root=new ListNode(e,root);
        size++;
    }

    /**
     * 从尾到头反过来打印出每个结点的值
     */
    public void printListInverselyUsingIteration() {
        Stack<ListNode> stack=new Stack();
        while (root!=null){
            stack.push(root);
            root=root.next;
        }
        ListNode temp=null;
        while (!stack.isEmpty()){
            temp=stack.pop();
            System.out.println(temp.val);
        }

    }


        public static void main(String[] args) {
        Jianzhi02 listnode=new Jianzhi02();
        listnode.addFirst(4);
        listnode.addFirst(3);
        listnode.addFirst(2);
        listnode.addFirst(1);
        listnode.printListInverselyUsingIteration();

    }
}
