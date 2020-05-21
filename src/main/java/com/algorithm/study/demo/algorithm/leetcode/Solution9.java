package com.algorithm.study.demo.algorithm.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xun2.liu
 * @title: Solution9
 * @projectName algorithm-study
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * @date 2020/5/21 13:46
 */
public class Solution9   {
    /**
     * 通过中心点向两边扩散。
     * @param s
     * @param r
     * @param l
     * @return
     */
    public static String palindrome(String s,int l,int r){
        while (l>=0 && r<s.length() && s.charAt(r)==s.charAt(l)){
            l--;r++;
        }
        //截取l-r中间的字符
        return s.substring(l+1,r);
    }
    public static String longestPalindrome(String s) {
        if (StringUtils.isBlank(s) || s.length()==1){
            return s;
        }
        String res="";
        for (int i=0;i<s.length()-1;i++){
            //判断aba汇文字符串
            String p1 = palindrome(s, i, i);
            //判断aa回文字符串
            String p2 = palindrome(s, i, i+1);
            System.out.println(p1);
            res=res.length()>=p1.length()?res:p1;
            res=res.length()>=p2.length()?res:p2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abc"));
    }
}
