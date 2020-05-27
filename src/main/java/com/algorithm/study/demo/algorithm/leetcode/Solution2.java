package com.algorithm.study.demo.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xun2.liu
 * @title: Solution2
 * @projectName algorithm-study
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * @date 2020/5/13 15:51
 */
public class Solution2 {
    /**
     * 使用滑动窗口
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end]
     * 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //最长子串 的长度
        int resultLen=0;
        //key为字符 value为end
        Map<Character,Integer> map= new HashMap<>();
        //初始化起始位置和结束位置
        int start=0;
        for(int end=0;end<s.length();end++){
            Character currChar=s.charAt(end);
            if(map.containsKey(currChar)){
                //移动start+1
                start=Math.max(start,map.get(currChar)+1);
            }
            //计算出start和end之间长度
            resultLen=Math.max(resultLen,end-start+1);
            //当前字符存入map中
            map.put(currChar,end);
        }
        return resultLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbcdefg"));
    }
}
