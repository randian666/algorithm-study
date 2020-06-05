package com.algorithm.study.demo.algorithm;

import com.algorithm.study.demo.model.User;
import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 排序算法-内排序
 * Created by liuxun on 2017/5/17.
 */
public class SortProject {
    // 被测试的方法集合
    static String[] methodNames = new String[]{
            "maopaoSort",
            "selectSort",
            "insertSort",
            "shellSort",
            "quick",
            "listSort",
            "mergeSort",
            "heapSort",
            "binaryTreeSort"
    };
    public static void main(String[] args) throws Exception {
        int[] ls=new int[]{30,1,15,11,40};
        Method method = SortProject.class.getDeclaredMethod(methodNames[4], ls.getClass());
        method.invoke(SortProject.class.newInstance(),ls);
    }

    /**
     * 算法性能测试
     * @param len
     * @throws Exception
     */
    public static void performanceTest(int len) throws Exception{
        int[] a = new int[len];
        int times = 10;//每个算法跑10次
        for(int i=0; i<methodNames.length; i++){
            Method method = SortProject.class.getDeclaredMethod(methodNames[i], a.getClass());
            int totalTime=0;//每个算法10次跑完的总时间
            for(int j=0; j<times; j++) {
                for (int k = 0; k < len; k++) {
                    a[k] = (int) Math.floor(Math.random() * 20000);
                }
                long begin=System.currentTimeMillis();
                method.invoke(SortProject.class.newInstance(),a);
                long end=System.currentTimeMillis();
                totalTime+=(end-begin);
            }
            System.out.println(methodNames[i] + "，总耗时: " + (totalTime) + " ms");
        }
    }
    /**
     * 冒泡排序：两两相邻比较记录的关键字，如果反序就交换，直到没有反序的记录为止。
     * 原地排序算法
     * 稳定排序算法
     * 时间复杂度为O(n²)
     * 空间复杂度为O(1)
     */
                    private static void maopaoSort(int score[]){
                        System.out.println("排序前："+ JSON.toJSONString(score));
                        boolean flag=true;//数据发生了交换才继续冒泡
                        for (int i = 1; i < score.length && flag; i++){    //最多做n-1趟排序
                            flag=false;
                            for(int j = 0 ;j < score.length - i; j++){    //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                                if(score[j] > score[j + 1]){    //把大或者小的值交换到后面
                                    int temp = score[j];
                                    score[j] = score[j + 1];
                                    score[j + 1] = temp;
                                    flag=true;//发生了数据交换
                }
            }
        }
        System.out.println("排序后："+ JSON.toJSONString(score));
    }

    /**
     * 在Java 6中Arrays.sort()和Collections.sort()使用的是MergeSort，而在Java 7中，内部实现换成了TimSort
     * TimSort算法是一种起源于归并排序和插入排序的混合排序算法
     * @param ls
     */
    private static void listSort(int ls[]){
        List asList=Arrays.asList(ls);
        Collections.sort(asList);
    }
    /**
     * 简单选择排序算法
     * 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕
     * 空间复杂度为O(1)
     * 非稳定排序
     * 时间复杂度为O(n²)
     * 性能上优于冒泡
     */
    private static void selectSort(int ls[]){
        System.out.println("排序前："+ JSON.toJSONString(ls));
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
        }
        System.out.println("排序后："+ JSON.toJSONString(ls));
    }

    /**
     * 插入排序算法
     * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
     * 将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。
     * 空间复杂度为O(1)
     * 稳定排序
     * 时间复杂度为O(n²)
     * 性能优于选择排序、冒泡排序
     */
    private static void insertSort( int ls[]){
        System.out.println("排序前："+ JSON.toJSONString(ls));
        for (int i=1;i<ls.length;i++){
            int key = ls[i];//需要插入的元素
            int j = i-1;//已经排好序的末索引
            for(;j>=0;j--){
                if (key<ls[j]) {
                    ls[j + 1] = ls[j];//将大于temp的值整体后移一个单位
                }else {
                    break;
                }
            }
            ls[j+1] = key;
        }
        System.out.println("排序后："+ JSON.toJSONString(ls));
    }
    /**
     * 希尔排序(Shell)算法
     * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为dl的倍数的记录放在同一个组中。
     * 先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<；…<d2<d1），
     * 即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
     */
    private static void shellSort( int ls[]){
        int d=ls.length;
        while (d>1){
            d=(d+1)/2;
            for(int i=0;i<ls.length-d;i++){
                if (ls[i+d]<ls[i]){
                    int temp=ls[i+d];
                    ls[i+d]=ls[i];
                    ls[i]=temp;
                }
            }
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
        //11,1,15,30,40
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

    /**快速排序方法（列表）*/
    public static void quickSortByList(List<User> list, int low, int high) {
        int lo = low;
        int hi = high;
        if (lo >= hi)
            return;

        //确定指针方向的逻辑变量
        boolean transfer=true;

        while (lo != hi) {
            if (list.get(lo).getId() > list.get(hi).getId()) {
                //交换
                User temp = list.get(lo);
                list.set(lo, list.get(hi));
                list.set(hi, temp);
                //决定下标移动，还是上标移动
                transfer =false;
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
        quickSortByList(list, low, lo);
        quickSortByList(list, hi, high);
    }
    public static void quick(int[] a2) {
        System.out.println("排序前："+JSON.toJSONString(a2));
        if (a2.length > 1) {    //查看数组是否为空
            quickSort(a2, 0, a2.length - 1);
        }
        System.out.println("排序后："+JSON.toJSONString(a2));
    }

    /**
     * 归并排序<br>
     * 所谓归并，就是合并两个有序数组；归并排序也用了分而治之的思想，把一个数组分为若干个子数组；<br>
     * 当子数组的长度为1的时候，则子数组是有序的，于是就可以两两归并了；<br>
     * <br>
     * 由于归并排序需要分配空间来转储归并的结果，为了算法上的方便，归并算法的结果以返回值的形式出现；<br>
     */

    /**
     * 合并两个有序数组
     * @param a 有序数组1
     * @param b 有序数组2
     * @return 合并之后的有序数组；
     */
    public static void merge(int[] a, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
    /**
     * 归并排序<br>
     * 把数组从中间一分为二，并对左右两部分递归调用，直到数组长度为1的时候，开始两两归并；<br>
     * 递推公式：
     * merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     * 终止条件：
     * p >= r 不用再继续分解
     * 时间复杂度: 平均:O(nlogn)，最好:O(nlogn);最坏:O(nlogn);
     * 空间复杂度: O(n);要为归并的结果分配空间
     * 稳定排序算法
     * 不是原地排序算法
     */
    public static int[] mSort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            mSort(a,low,mid);
            mSort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        System.out.println("排序后："+ JSON.toJSONString(a));
        return a;
    }
    public static int[] mergeSort(int[] a){
        return mSort(a,0,a.length-1);
    }



    /**
     * 堆排序<br>
     * 堆的定义：堆是一个完全，或近似完全的二叉树，堆顶元素的值大于左右孩子的值，左右孩子也需要满足这个条件；<br>
     * 按照堆的定义，堆可以是大顶堆(maxHeap)，或小顶堆(minHeap)；<br>
     * 一般用数组即可模拟二叉树，对于任意元素i，左孩子为2*i+1,右孩子为2*i+2;父节点为(i-1)/2;
     *
     * 时间复杂度: 平均:O(nlogn);
     * 空间复杂度: O(1);
     * @param a
     */
    public static void heapSort(int[] a){

        // 先从最后一个非叶子节点往上调整，使满足堆结构；
        for(int i=(a.length-2)/2; i>=0; i--){
            maxHeapAdjust(a, i, a.length);
        }
        // 每次拿最后一个节点和第一个交换，然后调整堆；直到堆顶；
        for(int i=a.length-1; i>0; i--){
            int tmp = a[i]; a[i] = a[0]; a[0] = tmp;
            maxHeapAdjust(a, 0, i);
        }
    }

    /**
     * 调整堆<br>
     * 把以i为跟节点的二叉树调整为堆；<br>
     * 可以这么来思考这个过程：这个完全二叉树就像一个金字塔，塔顶的小元素沿着树结构，往下沉降；<br>
     * 调整的结果是最大的元素在金字塔顶，然后把它从堆中删除(把它交换到堆尾，然后堆收缩一格)；<br>
     * 堆排序快的原因就是根据二叉树的特点，一个节点要沉降到合适的位置，只需要logn步；同时前期调整的结果(大小顺序)会被记录下来，从而加快后续的调整；<br>
     * @param a 待排数组
     * @param i 堆顶
     * @param len 堆长度
     */
    public static void maxHeapAdjust(int[] a, int i, int len){
        int tmp = a[i];
        // j是左孩子节点
        int j = i*2+1;
        //
        while(j<len){
            // 从左右孩子中挑选大的
            // j+1是右孩子节点
            if((j+1)<len && a[j+1]>a[j]){
                j++;
            }
            // 找到恰当的位置就不再找
            if(a[j]<tmp){
                break;
            }
            // 否则把较大者沿着树往上移动；
            a[i] = a[j];
            // i指向刚才的较大的孩子；
            i = j;
            // j指向新的左孩子节点；
            j = 2*i + 1;
        }
        // 把要调整的节点值下沉到适当的位置；
        a[i] = tmp;
    }


    /**
     * 二叉树排序<br>
     * 二叉树的定义是嵌套的：<br>节点的值大于左叶子节点的值，小于右叶子节点的值；叶子节点同样满足这个要求；<br>
     * 二叉树的构造过程就是排序的过程：<br>
     * 先构造跟节点，然后调用add方法添加后续节点为跟节点的子孙节点；这个过程也是嵌套的;<br>
     * <br>
     * 中序遍历二叉树即得到有序结果；<br>
     * 二叉树排序用法特殊，使用情形要视情况而定；<br>
     *
     * 时间复杂度: 平均:O(nlogn);
     * 空间复杂度: O(n);
     *
     * @param a
     */
    public static void binaryTreeSort(int[] a){
        // 构造一个二叉树节点内部类来实现二叉树排序算法；
        class BinaryNode{
            int value;
            BinaryNode left;
            BinaryNode right;

            public BinaryNode(int value){
                this.value = value;
                this.left = null;
                this.right = null;
            }

            public void add(int value){
                if(value>this.value){
                    if(this.right!=null){
                        this.right.add(value);
                    }
                    else{
                        this.right = new BinaryNode(value);
                    }
                }
                else{
                    if(this.left!=null){
                        this.left.add(value);
                    }
                    else{
                        this.left = new BinaryNode(value);
                    }
                }
            }
            /**
             * 按中序遍历二叉树，就是有序的。
             */
            public void iterate(){
                if(this.left!=null){
                    this.left.iterate();
                }
//                System.out.print(value + ", ");
                if(this.right!=null){
                    this.right.iterate();
                }

            }
        }

        BinaryNode root = new BinaryNode(a[0]);
        for(int i=1; i<a.length; i++){
            root.add(a[i]);
        }
        root.iterate();
    }
}
