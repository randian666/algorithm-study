package com.algorithm.study.demo.datastructure.linear;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun
 * @CreateDate: 2019/2/12 下午3:43
 * @Version: 1.0
 */
public class Solution {
    public static ListNode detectCycle(ListNode head) {
        ListNode temp=head;
        ListNode temp2=head;
        while(temp!=null && temp.next.next!=null){
            temp2=temp2.next.next;
            temp=temp.next;
            if (temp==temp2){
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

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        ListNode head0=new ListNode(1);

        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(-4);

        head.next=head0;
        head0.next=head1;
        head1.next=head2;
        head2.next=head1;
//        head1.next=head2;
//        head2.next=head3;
//        head3.next=head1;
        ListNode c=Solution.detectCycle(head);
        System.out.println(c==null?-1:1);


    }
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<2){
            return false;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
