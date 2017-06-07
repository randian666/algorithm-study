package com.algorithm.study.demo;

import java.util.*;

/**
 * Created by liuxun on 2017/6/6.
 */
public class LintcodeProject {
    public static void main(String[] args) {
//        String s="ajbkcodlejf";
//        String y="ajbkcodlejf";
//        System.out.println(anagram(s,y));
//        String A = "ABCDEFG";String B = "CDE";
//        System.out.println(strStr(A,B));
//        System.out.println(compareStrings(A,B));
//        String[] ss={"lint","intl","inlt","code"};
//        System.out.println(anagrams(ss).toString());
//        System.out.println(longestCommonSubstring("ABCD","ABCE"));
//        System.out.println(longestCommonPrefix(new String[]{"ABCD","EDED","ABD"}));
        int[] a={57,3,34,56,78};
        TreeNode root = new TreeNode(a[0]);
        for(int i=1; i<a.length; i++){
            root.add(a[i]);
        }
        ArrayList<Integer> list = searchRange(root, 50, 100);
        for (Integer i:list){
            System.out.print(i+"\t");
        }
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
    public static  int strStr(String source, String target) {
        if (null==source || target==null){
            return -1;
        }
        // write your code here
        return source.indexOf(target);
    }

    /**
     * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。
     * 对于字符串数组 ["lint","intl","inlt","code"] 返回 ["lint","inlt","intl"]
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {

        // write your code here
        List<String> list=new ArrayList<String>();
        if (null==strs || strs.length==0){
            return list;
        }
        Map<String,Integer> map=new HashMap<String, Integer>();
        for(String s:strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newStr=String.valueOf(c);
            if (map.containsKey(newStr)){
                map.put(newStr,map.get(newStr)+1);
            }else{
                map.put(newStr,1);
            }
        }
        for(String s:strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            if (map.get(String.valueOf(c))>1){
                list.add(s);
            }
        }
        return list;
    }

    /**
     * 给出两个字符串，找到最长公共子串，并返回其长度。
     * 给出A=“ABCD”，B=“CBCE”，返回 2
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A.length()==B.length() && A.equals(B)){
            System.out.println("最大公共子串是："+A);
            return A.length();
        }
        String max="";
        String minStr=A.length()<=B.length()?A:B;
        String maxStr=A.length()>B.length()?A:B;
        for(int i=0;i<minStr.length();i++){
            for(int j=i;j<minStr.length();j++){
                String n = minStr.substring(i, j + 1);
                if (maxStr.indexOf(n)!=-1 && n.length()>max.length()){
                    max=n;
                }
            }
        }
        System.out.println("最大公共子串是："+max);
       return max.length();
    }

    /**
     * 给k个字符串，求出他们的最长公共前缀(LCP)
     * 在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length==0) return "";
        String prifex = strs[0];        // 默认将第一个认为是最长共同
        for (int i=1;i<strs.length;i++){
            if (null==strs[i] || strs[i].equals("")){
                return "";
            }
            int min=prifex.length()>strs[i].length()?strs[i].length():prifex.length();
            for(int j=0;j<min;j++){
                if(prifex.charAt(j)!=strs[i].charAt(j)){
                    prifex=prifex.substring(0,j);
                    break;
                }
            }
        }
        System.out.println("最长公共前缀是："+prifex);
        return prifex;
    }
    public static ArrayList<Integer> searchList = new ArrayList<Integer>();
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        if(null==root) return searchList;
        if(root.val>=k1&&root.val<=k2){
            searchList.add(root.val);
            searchRange(root.left, k1, k2);
            searchRange(root.right, k1, k2);
        }else if(root.val<k1){
            searchRange(root.right, k1, k2);
        }else if(root.val>k2){
            searchRange(root.left, k1, k2);
        }
        Collections.sort(searchList);
        return searchList;
    }
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        public void add(int value){
            if(value>this.val){
                if(this.right!=null){
                    this.right.add(value);
                }else{
                    this.right = new TreeNode(value);
                }
            }
            else{
                if(this.left!=null){
                    this.left.add(value);
                }else{
                    this.left = new TreeNode(value);
                }
            }
        }
    }
}
