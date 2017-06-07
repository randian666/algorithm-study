package com.algorithm.study.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liuxun on 2017/6/7.
 */
public class Lintcode2Project {
    public static void main(String[] args) {
//        int[] A={-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25};
//        int count = removeElement(A, 4);
//        System.out.println(count);

//        removeDuplicates(A);

//        int[] A={3,5,11,12,13};
//        int[] B={4,5,6,7};
//        mergeSortedArray(A,A.length,B,B.length);
        int[] A={1,0,-1};
        int[] result = twoSum(A, -1);
        System.out.println(Arrays.toString(result));
    }
    /**
     * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。元素的顺序可以改变，并且对新的数组不会有影响。
     * 给出一个数组 [0,4,4,0,0,2,4,4]，和值 4 返回 4 并且4个元素的新数组为[0,0,0,2]
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public static int removeElement(int[] A, int elem) {
        // write your code here
        if (A.length==0) return 0;
        int count=A.length;
        int i=0;
        while (i<count){
            if (A[i]==elem){
                for(int j=i;j<count-1;j++){
                    //A[j]=A[j+1]; //后面的元素往前移
                    //两两交换位置
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
                count--;
            }else{
                i++;
            }
        }
//        A=Arrays.copyOf(A,count);
        System.out.println(Arrays.toString(A));
        return count;
    }

    /**
     * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
     * 给出 [-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]+nums[i+1]==0){

            }
        }
        return null;
    }

    /**
     * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
     * 给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]。
     * @param nums: a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length==0) return 0;
        int count=nums.length-1;
        int i=0;
        while(i<count){
            if (nums[i]==nums[i+1]){
                for(int j=i;j<count;j++){
                    nums[j]=nums[j+1];
                }
                count--;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums,count+1)));
        return (count+1);
    }
    /**
     * 合并两个排序的整数数组A和B变成一个新的数组。
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        A = Arrays.copyOf(A, m + n);//扩容
//        System.arraycopy(B, 0,A , m,n);//将第二个数组与第一个数组合并
//        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0&&j>=0){
            if(A[i]>B[j]){
                A[k--] = A[i];
                i--;
            }else{
                A[k--] = B[j];
                j--;
            }
        }
        while(j>=0&&k>=0){
            A[k--] = B[j--];
        }
        System.out.println(Arrays.toString(A));
    }

    /**
     * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
      * @param numbers : An array of Integer
      * @param target : target = numbers[index1] + numbers[index2]
      * @return : [index1 + 1, index2 + 1] (index1 < index2)
      */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int a=0;
        int m=numbers.length;
        while (a<=m){
            for (int j=(a+1);j<m;j++){
                if (numbers[a]+numbers[j]==target){
                    return new int[]{a+1,j+1};
                }
            }
            a++;
        }
        return null;
    }
}
