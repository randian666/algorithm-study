package com.algorithm.study.demo;

import java.util.Collections;

/**
 * 排序算法-内排序
 * Created by liuxun on 2017/5/17.
 */
public class SortProject {
    public static void main(String[] args) {
        int a[] = {69, 70, 2, 87,3};
//        maopaoSort(a);
//        selectSort(a);

//        insertSort(a);

//        shellSort(a);

        quick(a);

        System.out.print("最终排序结果：");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + "\t");
        }
    }

    /**
     * 冒泡排序
     * 两两相邻比较记录的关键字，如果反序就交换，直到没有反序的记录为止。
     */
    private static void maopaoSort(int score[]){
        boolean flag=true;//数据发生了交换才继续冒泡
        for (int i = 1; i < score.length && flag; i++){    //最多做n-1趟排序
            flag=false;
            for(int j = 0 ;j < score.length - i; j++){    //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                if(score[j] > score[j + 1]){    //把小的值交换到后面
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                    flag=true;//发生了数据交换
                }
            }
            System.out.print("第" + (i) + "趟排序结果：");
            for(int a = 0; a < score.length; a++){
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }
    }
    /**
     * 简单选择排序算法
     * 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕
     * 性能上优于冒泡
     */
    private static void selectSort(int ls[]){
        for (int i=0;i<ls.length-1;i++){
            int min=i;//记录数字最小的那个值的索引
            for (int j=(i+1);j<ls.length;j++){
                if (ls[min]>ls[j]){
                    min=j;
                }
            }
            if (min!=i){//说明已经找到最小值
                int temp=ls[i];
                ls[i]=ls[min];
                ls[min]=temp;
            }
            System.out.print("第" + (i + 1) + "趟排序结果：");
            for(int a = 0; a < ls.length; a++){
                System.out.print(ls[a] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * 插入排序算法
     * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
     * 性能优于选择排序、冒泡排序
     * {69, 70, 2, 87}
     */
    private static void insertSort( int ls[]){
        for (int i=1;i<ls.length;i++){
            int key = ls[i];
            int j = i-1;
            for(;j>=0&&key<ls[j];j--){
                ls[j+1]=ls[j];                       //将大于temp的值整体后移一个单位
            }
            ls[j+1] = key;

            System.out.print("第" + (i + 1) + "趟排序结果：");
            for(int a = 0; a < ls.length; a++){
                System.out.print(ls[a] + "\t");
            }
            System.out.println("");
        }
    }
    /**
     * 希尔排序(Shell)算法
     * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为dl的倍数的记录放在同一个组中。
     * 先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<；…<d2<d1），
     * 即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
     */
    private static void shellSort( int ls[]){
        int d=ls.length;
        int index=0;
        while (d>1){
            d=(d+1)/2;
            for(int i=0;i<ls.length-d;i++){
                if (ls[i+d]<ls[i]){
                    int temp=ls[i+d];
                    ls[i+d]=ls[i];
                    ls[i]=temp;
                }
            }
            index++;
            System.out.print("第" + index + "趟排序结果：");
            for(int a = 0; a < ls.length; a++){
                System.out.print(ls[a] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * 快速排序
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
     * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
     * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     * @param low
     * @param high
     * @return
     */
    public static void quickSort(int[] a,int low,int high) {
        int lo = low;
        int hi = high;

        if (lo >= hi)
            return;

        //确定指针方向的逻辑变量
        boolean transfer=true;
        while (lo != hi) {
            if (a[lo] > a[hi]) {
                //交换数字
                int temp = a[lo];
                a[lo] = a[hi];
                a[hi] = temp;
                //决定下标移动，还是上标移动
                transfer = false;
            }
            //将指针向前或者向后移动
            if(transfer)
                hi--;
            else
                lo++;
        }
        //将数组分开两半，确定每个数字的正确位置
        lo--;
        hi++;
        quickSort(a, low, lo);
        quickSort(a, hi, high);
    }
    public static void quick(int[] a2) {
        if (a2.length > 1) {    //查看数组是否为空
            quickSort(a2, 0, a2.length - 1);
        }
    }
}
