package com.algorithm.study.demo;

import com.algorithm.study.demo.mode.Rectangle;
import com.algorithm.study.demo.mode.RedShapeDecorator;
import com.algorithm.study.demo.mode.Shape;

/**
 * 查找算法
 * Created by liuxun on 2017/4/25.
 */
public class FindProject {
    public static void main(String[] args) {
        int[] is = new int[]{1, 2, 3, 4,5,6,10,11,12,13,14,15,16};
//        System.out.println(search(is,is.length-1,6));
        System.out.println(binarySearch(is,15));
//        Shape redRectangle = new RedShapeDecorator(new Rectangle());
//        redRectangle.doShaper();
    }

    /**
     * 求等差数列算法
     * 从1加到100
     */
    private static  void a(){
        //从1加到100
        int sum=0,n=10000;
        sum=(1+n)*n/2;
        System.out.println(sum);
    }
    /**
     * 顺序查找算法
     * @param a
     * @param key
     * @return
     */
    private static int search(int[] a,int key){
        int i=a.length-1;
        if (a[0]==key){
            return 0;
        }
        a[0]=key;
        while(a[i]!=key){
            i--;
        }
        if(i==0){
            return -1;//没找到
        }
        return i;
    }

    /**
     * 二分查找
     * @param srcArray
     * @param des
     * @return
     */
    public static int binarySearch(int[] srcArray, int des){
       int low=0;//最低下标
       int height=srcArray.length-1;//最高下标
       int middle=0;//中间下标
       while (low<=height){
           middle=(low+height)/2;//等价于 low+(height-low)/2
//           middle=low+(des-srcArray[low])/(srcArray[height]-srcArray[low])*(height-low);//插值算法-适合分布均匀的数据查找
           System.out.println("middle:"+middle);
           if (des==srcArray[middle]){
               return middle;
           }else if(des<srcArray[middle]){
                height=middle-1;
           }else{
               low=middle+1;
           }
       }
        return -1;

    }
}
