package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution7
 * @projectName algorithm-study
 * @description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 * @date 2020/5/19 17:16
 */
public class Solution7 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 快慢指针遍历连表。看是否相遇。如果相遇在判断是否是循环链表。
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (null== head || head.next==null){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                break;
            }
        }
        if (p1!=p2){
            return null;
        }
        p1=head;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(5);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(6);
        ListNode d=new ListNode(-1);
        a.next=b;
        b.next=c;
        c.next=b;
//        c.next=b;
        ListNode listNode = detectCycle(a);
        System.out.println(listNode==null?"":listNode.val);
    }
}
