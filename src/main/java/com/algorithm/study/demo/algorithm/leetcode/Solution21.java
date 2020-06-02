package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution21
 * @projectName algorithm-study
 * @description: 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * @date 2020/6/2 11:49
 */
public class Solution21 {
    public static int myAtoi(String str) {
        if(str==null) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false;
        //第一步，跳过前面若干个空格
        while(i<n && str.charAt(i)==' ') {
            ++i;
        }
        //如果字符串全是空格直接返回
        if(i==n) {
            return 0;
        }
        //第二步，判断正负号
        if(str.charAt(i)=='-') {
            is_negative = true;
        }
        //如果是正负号，还需要将指针i，跳过一位
        if(str.charAt(i)=='-' || str.charAt(i)=='+') {
            ++i;
        }
        //第三步，循环判断字符是否在 0~9之间
        while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i)-48;
            //判断是否大于 最大32位整数
            if(!is_negative &&(res>Integer.MAX_VALUE ||(res==Integer.MAX_VALUE && tmp>=7))) {
                return Integer.MAX_VALUE;
            }
            //判断是否小于 最小32位整数
            if(is_negative &&(-res<-Integer.MAX_VALUE || (-res==-Integer.MAX_VALUE && tmp>=8))) {
                return -Integer.MAX_VALUE;
            }
            res = res*10 + tmp;
            ++i;
        }
        //如果有负号标记则返回负数
        if(is_negative) {
            return -res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
    }
}
