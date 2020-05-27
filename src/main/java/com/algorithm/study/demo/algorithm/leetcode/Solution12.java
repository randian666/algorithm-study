package com.algorithm.study.demo.algorithm.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 */
public class Solution12 {
    public static int strStr(String haystack, String needle) {
        int len=haystack.length();
        int n=needle.length();
        if (n>len){
            return -1;
        }
        if (len==n && haystack.equals(needle)){
            return 0;
        }
        for (int i=0;i<len-n+1;i++){
            if (haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(strStr("abc","bc"));
    }
}
