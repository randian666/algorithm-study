package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution6
 * @projectName algorithm-study
 * @description: 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * @date 2020/5/18 19:35
 */
public class Solution6 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //使用两个指针分别指向headA、headB
        //同时遍历两个连表
        //当headA遍历完后指针指向headB，当headB遍历完后指针指向headA
        //如此循环当两个指正都为Null的话代表没有相交的节点。
        //如果都两个指针对应的节点相等就返回相等的节点就是相交的节点
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(5);
        ListNode b=new ListNode(4);
        a.next=b;
        ListNode c=new ListNode(6);
        ListNode intersectionNode = getIntersectionNode(a, b);
        if (null!=intersectionNode){
            System.out.println(intersectionNode.val);
        }else{
            System.out.println("没有相交的节点哦");
        }

    }
}
