package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution5
 * @projectName algorithm-study
 * @description: 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @date 2020/5/14 20:07
 */
public class Solution5 {
 public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
  public static ListNode reverseList(ListNode head) {
        //使用两个指针
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            //临时指针。用来存储下一个节点。
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
  }

    public static void main(String[] args) {
        ListNode a=new ListNode(5);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(3);
        a.next=b;b.next=c;
        ListNode result = reverseList(a);
        for (ListNode node=result;node!=null;node=node.next){
            System.out.println(node.val);
        }
    }
}
