package com.algorithm.study.demo.datastructure.linear;

/**
 * 求一个字符串的最大不重复子串
 * 单链表链表算法题
 * @Author: liuxun
 * @CreateDate: 2019/2/12 下午3:43
 * @Version: 1.0
 */
public class Solution {

    /**
     * 环形链表检测
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode temp=head;
        ListNode temp2=head;
        while(temp!=null && temp.next.next!=null){
            //通过快慢指针遍历
            temp2=temp2.next.next;
            temp=temp.next;
            if (temp==temp2){
                //寻找环形入口
                ListNode q = head;
                while(temp2!=q){
                    temp2=temp2.next;
                    q=q.next;
                }
                return q;
            }
        }
        return null;
    }

    /***
     * 单链表的前K个的逆序输出
     *
     */
    public static void reversedTopK(ListNode head,int k){
        if (head==null || head.next==null){
            return;
        }
        printNode(head);
        int count=1;
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode p3=null;
        while (count<k){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
            count++;
        }
        head.next=null;
        System.out.println("执行完毕");
        printNode(p1);
    }

    /**
     * 反转链表O(n)复杂度实现
     */
    public static void reverseLinkedList(ListNode data){
        if (data==null || data.next==null){
            return;
        }
        printNode(data);
        ListNode p1=data;
        ListNode p2=data.next;
        ListNode p3=null;
        while (p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        data.next=null;
        data=p1;
        System.out.println();
        System.out.println("反转完毕");
        printNode(data);
    }
    public static void printNode(ListNode data){
        for (ListNode temp=data;temp!=null;temp=temp.next){
            System.out.print(temp.val+"->");
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        ListNode head0=new ListNode(1);

        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(-4);

//        head.next=head0;
//        head0.next=head1;
//        head1.next=head2;
//        head2.next=head1;
//        ListNode c=Solution.detectCycle(head);
//        System.out.println(c==null?-1:1);

        head.next=head0;
        head0.next=head1;
        head1.next=head2;
        head2.next=null;
//        Solution.reverseLinkedList(head);
        Solution.reversedTopK(head,2);
    }
}
