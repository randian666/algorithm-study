package com.algorithm.study.demo.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author xun2.liu
 * @title: Solution26
 * @projectName algorithm-study
 * @description: 删除链表中的元素
 * @date 2020/6/17 13:40
 */
public class Solution26 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode delNode(ListNode head,int val){
        //首先删除头结点等于val的节点
        while (head!=null && head.val==val){
            head=head.next;
        }
        if (head==null){
            return head;
        }
        //删除头结点后边等于val的节点
        ListNode temp=head;
        while (temp.next!=null){
            if (temp.next.val==val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(0);
        ListNode b=new ListNode(1);
        ListNode c=new ListNode(2);
        a.next=b;b.next=c;
        ListNode temp=a;
        while (temp!=null){
            delNode(temp, 2);
            temp=temp.next;
        }
        System.out.println(JSON.toJSONString(a));

    }
}
