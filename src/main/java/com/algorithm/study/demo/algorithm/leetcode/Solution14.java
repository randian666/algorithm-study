package com.algorithm.study.demo.algorithm.leetcode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class Solution14 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //需要返回排序好的节点
        ListNode result=new ListNode(-1);
        //哨兵节点
        ListNode prev=result;
        //首先遍历两个链表比较大小如果l1比l2小。l1往前走否则l2往前走。并且把值小的节点赋值给prev.next。
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                prev.next=l1;
                l1=l1.next;
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        //合并剩下没有比较完的链表，因为剩下的链表已经排序好的。所以直接赋值即可。
        prev.next=l1==null?l2:l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        a.next=b;

        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        c.next=d;

        ListNode listNode = mergeTwoLists(a, c);
        for (ListNode node = listNode; node!=null; node=node.next){
            System.out.println(node.val);
        }
        
    }
}
