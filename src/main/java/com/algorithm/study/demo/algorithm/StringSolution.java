package com.algorithm.study.demo.algorithm;

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

    public static void main(String[] args) {
        System.out.println(StringSolution.indexOf("ab","asdkfjasldjfab"));
        System.out.println("asdkfjasldjfab".indexOf("ab"));
    }
}
