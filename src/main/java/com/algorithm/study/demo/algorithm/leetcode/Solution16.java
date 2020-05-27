package com.algorithm.study.demo.algorithm.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 */
public class Solution16 {
    /**
     * 使用双指针对比字符相等
     * @param s
     * @param l
     * @param r
     * @return
     */
    public static boolean palindrome(String s,int l,int r){
        String news=s.toLowerCase();
        while(l<r){
            if(!isCharOrNum(news.charAt(l)) ){
                l++;
                continue;
            }
            if(!isCharOrNum(news.charAt(r)) ){
                r--;
                continue;
            }
            if(news.charAt(l)!=news.charAt(r)){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }

    /**
     * 判断字符是否在字母或者数字
     * @param c
     * @return
     */
    public  static boolean isCharOrNum(char c){
        return Character.isLetterOrDigit(c);
    }
    public static boolean isPalindrome(String s) {
        if(s.length()==0 ){
            return true;
        }
        return palindrome(s,0,s.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
