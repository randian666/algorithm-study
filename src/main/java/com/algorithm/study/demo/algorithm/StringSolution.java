package com.algorithm.study.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串算法系列
 * @Author: liuxun
 * @CreateDate: 2019/3/19 下午2:26
 * @Version: 1.0
 */
public class StringSolution {
    /**
     * 判断一个字符串是否在另外一个字符串中，并返回出现的位置
     * @param src
     * @param dst
     * @return
     */
    public static int indexOf(String src,String dst){
        if (null==src || null==dst || src.length()<1 || dst.length()<1 || dst.length()<src.length()){
            return -1;
        }
        char[] srcArray = src.toCharArray();
        char[] dstArray = dst.toCharArray();
        int dlength=dstArray.length;
        int slength=srcArray.length;
        for (int i=0;i<=dlength-slength;i++){
            int index=i;//下标
            boolean isEq=true;//判断是否相等
            for (int j=0;j<srcArray.length;j++){
                if (srcArray[j]!=dstArray[j+i]){
                    isEq=false;
                    break;
                }
            }
            if (!isEq){
                continue;
            }
            return index;
        }
        return -1;
    }

    /**
     * 手写字符串转换成小写
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        if (null==str || str.length()==0){
            return str;
        }
        char[] strArr = str.toCharArray();
        for (int i = 0,len=strArr.length;i < len; i++) {
            //判断是否为大写
            if (Character.isUpperCase(strArr[i])) {
                strArr[i] +=32;
            }
        }
        return String.valueOf(strArr);
    }

    /**
     * 反转字符串
     * @param s
     */
    public static String reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while (i<j){
            char c = s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
        return String.valueOf(s);
    }

    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
     * 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     */
    private static String[] m=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> objects = new HashSet<>();
        for (String w:words){
            StringBuilder sb=new StringBuilder();
            char[] chars = w.toCharArray();
            for (char aChar : chars) {
                sb.append(m[aChar-'a']);
            }
            System.out.println("密码为："+sb);
            objects.add(sb.toString());
        }
        return objects.size();
    }

    public static void main(String[] args) {
//        System.out.println(StringSolution.indexOf("ab","asdkfjasldjfab"));
//        System.out.println("asdkfjasldjfab".indexOf("ab"));

//        System.out.println(StringSolution.toLowerCase("ccccccccccBB"));
        System.out.println(StringSolution.reverseString("abc".toCharArray()));
        System.out.println(StringSolution.uniqueMorseRepresentations(new String[]{"abc","cba"}));
    }
}
