package com.algorithm.study.demo.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author xun2.liu
 * @title: Solution11
 * @projectName algorithm-study
 * @description: 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 *
 * https://leetcode-cn.com/problems/remove-element
 * @date 2020/5/21 16:15
 */
public class Solution11 {
    public static int removeElement1(int[] nums, int val) {
        //双指针
        int i=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]==val){
                //跟最后一个元素交换
                nums[i]=nums[n-1];
                //释放最后一个元素
                n--;
            }else{
                //继续往前走
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,2,1};
        System.out.println(removeElement1(nums,3));
    }
}
