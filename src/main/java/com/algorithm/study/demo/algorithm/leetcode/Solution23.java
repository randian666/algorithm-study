package com.algorithm.study.demo.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author xun2.liu
 * @title: Solution23
 * @projectName algorithm-study
 * @description: 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * @date 2020/6/5 13:50
 */
public class Solution23 {
    /**
     * 归并排序
     * https://www.cnblogs.com/chengxiao/p/6194356.html
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp=new int[nums.length];
        mSort(nums,0,nums.length-1,temp);
        return nums;
    }

    public static void mSort(int[] nums,int left,int right,int[] temp){
        if (left<right){
            //寻找中间点。用于分治
            int mid=(left+right)/2;
            //左边排序
            mSort(nums,left,mid,temp);
            //右边排序
            mSort(nums,mid+1,right,temp);
            //然后左右合并
            merge(nums,left,mid,right,temp);
        }
    }
    public static void merge(int[] nums,int left,int mid,int right,int[] temp){
        //左序列指针
        int i=left;
        //右序列指针
        int j=mid+1;
        //临时数组指针
        int t=0;
        while (i<=mid && j<=right){
            if (nums[i]<=nums[j]){
                temp[t++]=nums[i++];
            }else{
                temp[t++]=nums[j++];
            }
        }

        //将左序列剩余元素填充进temp中
        while (i<=mid){
            temp[t++]=nums[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j<=right){
            temp[t++]=nums[j++];
        }

        //将temp中的元素全部拷贝到原数组中
        t=0;
        while (left<=right){
            nums[left++]=temp[t++];
        }
    }

    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
