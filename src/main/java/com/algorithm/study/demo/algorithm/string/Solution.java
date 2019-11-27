package com.algorithm.study.demo.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xun2.liu
 * @title: Solution
 * @projectName algorithm-study
 * @description: 给定一个字符串，查找不重复字符的最长子字符串的长度。
 * @date 2019/11/27 11:15
 */
public class Solution {
    int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));//如果不包含，j就自增
                ans = Math.max(ans, j - i);//j - i = 最大的不重复的长度。
            } else {
                set.remove(s.charAt(i++));//如果包含，i就增,并把窗口后滑
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "jkklmmds";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
