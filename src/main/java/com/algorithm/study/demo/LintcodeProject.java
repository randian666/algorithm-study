package com.algorithm.study.demo;

import java.util.Arrays;

/**
 * Created by liuxun on 2017/6/6.
 */
public class LintcodeProject {
    public static void main(String[] args) {
//        String s="ajbkcodlejf";
//        String y="ajbkcodlejf";
//        System.out.println(anagram(s,y));
        String A = "ABCDEFG";String B = "CDE";
        System.out.println(A.indexOf(B));
        System.out.println(compareStrings(A,B));
    }

    /**
     * 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串
     * 给出 s = "abcd"，t="dcab"，返回 true
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
    public static boolean anagram(String s, String t) {
        // write your code here
        char[] c1 = s.toCharArray();
        Arrays.sort(c1);

        char[] c2 = t.toCharArray();
        Arrays.sort(c2);
        // 比较长度是否一样
        if (c1.length != c2.length) {
            return false;
        }
        // 比较成员是否对应相等
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
     * 给出 A = "ABCD" B = "ACD"，返回 true
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
        // write your code here
        char[] c1=A.toCharArray();
        char[] c2 = B.toCharArray();
        if (c2.length==0){
            return true;
        }
        // 比较成员是否对应相等
        int count=0;
        for(int a=0;a<c2.length;a++){
            if (count==c2.length){
                break;
            }
            for (int i = 0; i < c1.length; i++) {
                if(c2[a]==c1[i]){
                    count++;
                    c1[i]='0';//如果发现相等的字符就把A对应的下标的值替换成0，避免B中出现重复字符去A中匹配。
                    break;
                }
                if (i==(c1.length-1)){//如果当前字符不在A中 结束整个程序
                    return false;
                }
            }
        }
        if (count==c2.length){
            return true;
        }
        return false;
    }

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (null==source || target==null){
            return -1;
        }
        // write your code here
        return source.indexOf(target);
    }
}
