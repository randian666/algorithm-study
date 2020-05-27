package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution15
 * @projectName algorithm-study
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *  *
 *  * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *  *
 *  * 示例 1:
 *  * s = "abc", t = "ahbgdc"
 *  *
 *  * 返回 true.
 *  *
 *  * 示例 2:
 *  * s = "axc", t = "ahbgdc"
 *  *
 *  * 返回 false.
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/is-subsequence
 * @date 2020/5/27 19:58
 */
public class Solution15 {
    /**
     * 使用双指针i、n，如果s.charAt(i)等于t.charAt(n)的话，i、n指针都往前走。最后判断相等的次数是否等于s字符串的长度。
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int i=0;
        int n=0;
        while(i<s.length() && n<t.length()){
            if(s.charAt(i)==t.charAt(n)){
                i++;
                n++;
            }else{
                n++;
            }
        }
        if(i==s.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("aabc","aasssbdkjic"));
    }
}

