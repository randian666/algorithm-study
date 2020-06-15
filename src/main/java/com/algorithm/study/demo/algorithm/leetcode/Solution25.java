package com.algorithm.study.demo.algorithm.leetcode;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution25 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        //令最长公共前缀 ans 的值为第一个字符串，进行初始化
        String commonStr=strs[0];
        for (int i = 1; i < strs.length; i++) {
            //进行匹配的字符串
            String str = strs[i];
            //公共前缀的下标
            int j=0;
            for (;j<commonStr.length() && j<str.length();j++){
                //如果初始的字符串中的第J个字符不等于进行匹配的字符就退出
                if (commonStr.charAt(j)!=str.charAt(j)){
                    break;
                }
            }
            commonStr=commonStr.substring(0,j);
            //判断是否有公共前缀
            if ("".equals(commonStr)) {
                return "";
            }
        }
        return commonStr;
    }

    public static void main(String[] args) {
        Solution25 so=new Solution25();
        String[] params={"flower","flow","flight"};
        System.out.println(so.longestCommonPrefix(params));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
