package com.algorithm.study.demo.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 单链表操作
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

    /**
     * 添加元素到链表头部
     * @param e
     */
    public  void addFirst(int e){
        ListNode first=root;
        ListNode listNode=new ListNode(e,null);
        root=listNode;
        if (first==null){
            last=listNode;
        }
        size++;
    }

    /**
     * 添加元素到链表末尾
     * @param e
     */
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
    public int size(){
        return size;
    }
    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     */
    public void printListInverselyUsingIteration() {
        Stack<ListNode> stack=new Stack();
        ListNode tempNode=root;
        while (tempNode!=null){
            stack.push(tempNode);
            tempNode=tempNode.next;
        }
        ListNode temp=null;
        while (!stack.isEmpty()){
            temp=stack.pop();
            System.out.println(temp.val);
        }

    }
    /****
     *单链表反转
     */
    public ListNode reversalNode(){
        //当前节点的上一个节点
        ListNode previousNode = null;
        //当前节点
        ListNode currentNode = root;
        //返回反转后的节点
        ListNode headNode = null;
        while (currentNode != null) {
            //当前节点的下一个节点
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            System.out.println();
        }
        return headNode;
    }
    /**
     * 链表中环检测
     *      *合并两个有序链表
     *      * 删除链表倒数第N个节点
     *      * 求链表的中间节点
     * @param args
     */


        public static void main(String[] args) {
        Jianzhi02 listnode=new Jianzhi02();
        listnode.add(4);
        listnode.add(3);
        listnode.add(2);
        listnode.add(1);
        System.out.println("size:"+listnode.size());
        listnode.printListInverselyUsingIteration();
        listnode.reversalNode();
    }
}
