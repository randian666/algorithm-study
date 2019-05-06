package com.algorithm.study.demo.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 算法面试题
 * @Author: liuxun
 * @CreateDate: 2019/2/13 下午3:11
 * @Version: 1.0
 */
public class Solution {

    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            result = 0;
        return (int)result;
    }

    /**
     * 求一个字符串的最大不重复子串
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                //删除重复的字符
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 求2个有序数组的有序交集
     * @param args
     */
    public static void arrayIntersection(int[] a,int[] b){
        int lena=a.length;
        int lenb=b.length;
        if (lena==0 || lenb==0){
            System.out.println("无数据交集");
            return;
        }
        int i=0,j=0;
        List<Integer> result=new ArrayList<>();
        while (i<lena && j<lenb){
            if (a[i]<b[j]){
                i++;
            }else if(a[i]>b[j]){
                j++;
            }else{
                result.add(a[i]);
                i++;
                j++;
            }
        }
        System.out.println("交集为："+ JSON.toJSONString(result));
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abaa"));
        int[] a = { 2, 3, 4, 4, 4, 4, 7, 8, 8, 8, 8, 9, 100, 130, 150, 160 };
        int[] b = { 4, 6, 7, 7, 7, 7, 8, 8, 9, 10, 100, 130, 130, 140, 150 };
        arrayIntersection(a,b);
    }

}
