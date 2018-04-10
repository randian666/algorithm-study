package com.algorithm.study.demo.algorithm;

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
//        int[] A={1,0,-1};
//        int[] result = twoSum(A, -1);
//        System.out.println(Arrays.toString(result));

//        ArrayList<Integer> list=new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(productExcludeItself(list).toString());
//        int[] A={1,3,4,5};
//        System.out.println(threeSumClosest(A,2));

        ss();
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
//        int a=0;
//        int m=nums.length;
//        while (a<=m){
//            for (int j=(a+1);j<m;j++){
//                if (nums[a]+nums[j]==0){
//                    return new int[]{a+1,j+1};
//                }
//            }
//            a++;
//        }
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

    /**
     * 数组剔除元素后的乘积
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        for(int i=0;i<A.size();i++){
            Long mul = 1L;
            for(int j=0;j<A.size();j++){
                if(j!=i){
                    mul = mul*A.get(j);
                }
            }
            result.add(mul);
        }

        return result;
    }
    /**
     * 丢失的第一个正整数
     * 给出一个无序的正数数组，找出其中没有出现的最小正整数。
     * 如果给出 [1,2,0], return 3
     * @param A: an array of integers
     * @return: an integer
     */
    public static int firstMissingPositive(int[] A) {
        // write your code here
        Arrays.sort(A);
        int data = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i]>0 && A[i]-data > 1)
                return data +1;
            else if (A[i] > 0)
                data = A[i];
        }
        return data + 1;
    }

    /**
     * 最接近的三数之和
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public static int threeSumClosest(int[] numbers, int target) {
        // write your code here
        // 记录最小的差值
        long minDiff = Long.MAX_VALUE;
        // 记录最小差值对应的三个整数和
        long result = 0;
        // 每次求得的差值
        long diff;
        // 每次求得的三个整数的和
        long sum;

        // 先对数组进行排序
        Arrays.sort(numbers);

        // i表示假设取第i个数作为结果
        for (int i = 0; i < numbers.length - 2; i++) {
            // 第二个数可能的起始位置
            int j = i + 1;
            // 第三个数可能是结束位置
            int k = numbers.length - 1;

            while (j < k) {
                // 求当前三个数的和
                sum = numbers[j] + numbers[k] + numbers[i];
                // 当前和与目标和之间的差值
                diff = Math.abs(target - sum);

                // 差值为0就直接返回
                if (diff == 0) {
                    return (int) sum;
                }

                // 如果当前的差值比之前记录的差值小
                if (diff < minDiff) {
                    // 更新最小的差值
                    minDiff = diff;
                    // 更新最小差值对应的和
                    result = sum;

                    // 以上的设置在下一次元素处理时生效
                }
                // 和大于target
                if (sum > target) {
                    k--;
                }
                // 和小于target
                else {
                    j++;
                }
            }
        }
        return (int) result;
    }


    public static String longestPalindrome1(String s) {

        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        // check all possible sub strings
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i;
                String curr = s.substring(i, j + 1);
                if (isPalindrome(curr)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }

        return longestPalindrome;
    }
    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void ss(){
        String s="abccba";
        int[] a = new int[58];
        for(int i=0;i<58;i++){
            a[i]=0;
        }
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            int temp = c[i]-'A';
            a[temp]++;
        }
        int length = 0;
        boolean flat1 = false;
        for(int i=0;i<58;i++){
            length += (a[i]/2)*2;
            if(a[i]%2==1){
                flat1=true;
            }
        }
        if(flat1)length++;
        System.out.println(length);

    }
}
