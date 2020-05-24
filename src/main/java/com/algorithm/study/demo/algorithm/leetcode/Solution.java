package com.algorithm.study.demo.algorithm.leetcode;

import com.algorithm.study.demo.LRUCache.LRUCache;

/**
 * @author xun2.liu
 * @title: Solution
 * @projectName algorithm-study
 * @description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * @date 2020/5/9 14:42
 */
public class Solution {
    static class ListNode{
        private int val;
        private ListNode next;
        private ListNode(int val){
            this.val=val;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //返回的结果,初始化
        ListNode result=new ListNode(0);
        //j结果游标
        ListNode curr=result;
        //满十进1，存储进位
        int carry=0;
        while(l1!=null || l2!=null){
            int p1=l1==null?0:l1.val;
            int p2=l2==null?0:l2.val;
            //计算当前两数相加后的值
            int sum=p1+p2+carry;
            //计算相加后的值的进位
            carry=sum/10;
            //存储当前相加后的值除以10的余数
            curr.next=new ListNode(sum%10);
            //游标指向下个节点
            curr=curr.next;

            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (carry>0){
            curr.next=new ListNode(carry);
        }
        return result.next;
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(5);
        ListNode b=new ListNode(5);
        a.next=b;


        ListNode result = addTwoNumbers(a, a);
        for (ListNode node=result;node!=null;node=node.next){
            System.out.println(node.val);
        }
    }
}
