package com.algorithm.study.demo;

/**
 * 排序算法-内排序
 * Created by liuxun on 2017/5/17.
 */
public class SortProject {
    public static void main(String[] args) {
        int a[] = {70, 69, 100, 87, 89, 90, 2, 1};
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
        for (int i = 0; i < score.length -1 && flag; i++){    //最多做n-1趟排序
            flag=false;
            for(int j = 0 ;j < score.length - i - 1; j++){    //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                if(score[j] > score[j + 1]){    //把小的值交换到后面
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                    flag=true;//发生了数据交换
                }
            }
            System.out.print("第" + (i + 1) + "趟排序结果：");
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
     * 插入排序就是把当前待排序的元素插入到一个已经排好序的列表里面
     * 性能优于选择排序、冒泡排序
     */
    private static void insertSort( int ls[]){
        for (int i=1;i<ls.length;i++){//默认0是已排序的的列表
            int m=i;//待排序的元素
            for (int j=i;j>0;j--){
                if (ls[m]<ls[j-1]){
                    int temp=ls[m];
                    ls[m]=ls[j-1];
                    ls[j-1]=temp;
                    m=j-1;
                }
            }
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
     * @param list
     * @param low
     * @param high
     * @return
     */
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }
    public static void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }
}
