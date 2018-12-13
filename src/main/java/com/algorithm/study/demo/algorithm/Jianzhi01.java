package com.algorithm.study.demo.algorithm;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p/>
 * 规律：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
 * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
 * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
 **/

public class Jianzhi01 {

    public static boolean find(int[][] matrix, int number) {

        if (matrix==null || matrix.length<1 || matrix[0].length<1){
            return false;
        }

        int rows=matrix.length;//数组的行数
        int cols=matrix[0].length;//数组的列数

        int row=0;//从第1行开始读取
        int col=cols-1;//从第1列开始

        while (row>=0 && row<rows && col>=0){
             if (matrix[row][col]==number){
                 return true;
             }else if(matrix[row][col]>number){
                 col--;//从右往左边开始读取
             }else{
                 row++;//读取下一行
             }
        }
        return  false;


    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 15));    // 要查找的数在数组中
    }
}
