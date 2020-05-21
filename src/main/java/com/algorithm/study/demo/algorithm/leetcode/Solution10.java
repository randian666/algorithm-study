package com.algorithm.study.demo.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xun2.liu
 * @title: Solution10
 * @projectName algorithm-study
 * @description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * @date 2020/5/21 15:34
 */
public class Solution10 {
    //通过中心扩散法查找回文字符串
    public static void huiwen(String s,int l,int r,List<String> filter){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;r++;
            filter.add(s.substring(l+1,r));
        }
    }

    public static int countSubstrings(String s) {
        if(null==s || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        List<String> filter=new ArrayList<String>();
        for(int i=0;i<s.length();i++){
            huiwen(s,i,i,filter);
            huiwen(s,i,i+1,filter);
        }
        return filter.size();
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
