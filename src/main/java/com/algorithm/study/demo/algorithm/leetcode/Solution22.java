package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution22
 * @projectName algorithm-study
 * @description: 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * @date 2020/6/3 20:07
 */
public class Solution22 {
    public static String compressString(String S) {
        //慢指针
        int i=0;
        int len=S.length();
        //压缩后的字符串
        StringBuilder sb=new StringBuilder();
        while(i<len){
            //快指针
            int j=i;
            //j<len防止越界，判断快慢指针对应的字符是否一致。如果一致的话快指正继续往前走。
            while(j<len && S.charAt(i)==S.charAt(j)){
                j++;
            }
            sb.append(S.charAt(i)).append(j-i);
            //最后调整慢指针跟快指针对齐
            i=j;
        }
        if(sb.length()<S.length()){
            return  sb.toString();
        }
        return S;
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}
