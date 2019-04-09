package com.algorithm.study.demo.datastructure.linear;

/**
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

    /**
     为了能够只遍历一次就能找到倒数第k个节点，可以定义两个指针：
 　　（1）第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；
 　　（2）从第k步开始，第二个指针也开始从链表的头指针开始遍历；
 　　（3）由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k个结点。
     * @param data 链表
     * @param k k个节点
     */
    public static void findKthToTail(ListNode data,int k){
        ListNode aNode=data;
        ListNode bNode=null;
        //第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；
        for (int i = 0; i <k-1 ; i++) {
            if (aNode.next!=null){
                aNode=aNode.next;
            }else{
                System.out.println("查找链表越界");
                return;
            }
        }
        bNode=data;
        while (aNode.next!=null){
            aNode=aNode.next;
            bNode=bNode.next;
        }
        System.out.println("倒数第"+k+"个节点为："+bNode.val);
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
//        Solution.reversedTopK(head,2);

        Solution.findKthToTail(head,2);
    }
}
