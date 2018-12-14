package com.algorithm.study.demo.algorithm;

import java.util.LinkedList;
import java.util.List;
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
    private  ListNode last;
    public  void addFirst(int e){
        ListNode first=root;
        ListNode listNode=new ListNode(e,null);
        root=listNode;
        if (first==null){
            last=listNode;
        }
        size++;
    }
    public  void add(int e){
        ListNode temp=last;
        if (temp==null){
            addFirst(e);
            return;
        }else{
            ListNode node =new ListNode(e,null);
            temp.next=node;
            last=node;
        }
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
        listnode.add(4);
        listnode.add(3);
        listnode.add(2);
        listnode.add(1);
        listnode.printListInverselyUsingIteration();
        LinkedList linkedList=new LinkedList();
        linkedList.add(1);

    }
}
