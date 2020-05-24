package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution8
 * @projectName algorithm-study
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * @date 2020/5/20 21:01
 */
public class Solution8 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1步，而第二个指针将从列表的开头出发。现在，这两个指针被n个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第n个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null){
            return null;
        }
        //增加一个头部节点，方便删除倒数的节点刚好是第一个节点。
        ListNode temp=new ListNode(-1);
        temp.next=head;
        ListNode p1=temp;
        ListNode p2=temp;
        //第一个指针从列表的开头向前移动 n+1步
        for (int i=0;i<n+1;i++){
            p1=p1.next;
        }
        //然后两个指针一起向前移动直到遍历到尾
        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;
//        b.next=c;
//        c.next=d;
//        d.next=e;
        ListNode listNode = removeNthFromEnd(a, 2);
        System.out.println("删除后的链表");
        for (ListNode node = listNode; node!=null; node=node.next){
            System.out.println(node.val);
        }
    }
}
