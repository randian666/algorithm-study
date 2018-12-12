package com.algorithm.study.demo.string;

/**
 * Created by liuxun on 2017/6/22.
 */
public class TestString {
    public static void main(String[] args) {
        TestString test = new TestString();

        System.out.println(test.Index("goodgoogle", "google", 0));

        System.out.println(test.indexKMP("goodgoogle", "google", 0));
    }

    //朴素模式匹配算法
    public int Index(String s,String t,int pos){

        int i = pos;//主串中第几个位置开始比较
        int j = 0;//模式串中的第一个位置
        while(i<s.length()&&j<t.length()){

            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                i = i-j+1;//主串的下一个位置
                j = 0;//继续第一个位置
            }
        }

            if (j>=t.length()) {
            return i-t.length();
        }else {
            return -1;
        }

    }

    //////////KMP模式匹配算法////////////////
    public int[] getNext(String T){
        int[] next = new int[T.length()];
        int i = 0;
        int j = -1;

        next[i] = j;

        while(i<T.length()-1){

            if(j==-1 || T.charAt(i)==T.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];//若字符不相等，则j值进行回溯。
            }
        }
        for (int k = 0; k < next.length; k++) {
            System.out.print(next[k]);
        }
        System.out.println();
        return next;
    }

    public int indexKMP(String S,String T,int pos){
        int i = pos;//表示从主串中第几个字符串开始匹配

        int j = 0;//表示从模式串中第几个字符串开始

        int[] next = getNext(T);

        while(i<S.length()&&j<T.length()){
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            }
            else {//重新开始匹配
                j = next[j];//j退回到合适的位置，i值不变
            }
        }
        if (j>=T.length()) {
            return i-T.length();
        }else {
            return 0;
        }
    }
}
