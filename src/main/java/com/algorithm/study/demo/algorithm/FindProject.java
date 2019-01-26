package com.algorithm.study.demo.algorithm;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 查找算法
 * Created by liuxun on 2017/4/25.
 */
public class FindProject {
    public static void main(String[] args) {

        int[] is=new int[]{3,5,6,7,10};
        System.out.println(binary_search_xiaoyu(is,10));
//        System.out.println(binarySearch(is,2));
//        Shape redRectangle = new RedShapeDecorator(new Rectangle());
//        redRectangle.doShaper();


    }



    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        //write your code here
        int low=0;
        int heigth=nums.length-1;
        int middle;
        while (low<=heigth){
            middle=(low+heigth)/2;
            if (target==nums[middle]){
                for (int i=(middle-1);i>=0;i--){
                    if (nums[i]==target){
                        middle=i;
                    }else{
                        break;
                    }
                }
                return middle;
            }else if(target>nums[middle]){
                low=middle+1;
            }else{
                heigth=middle-1;
            }
        }
        return -1;
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
    public static int binary_search(int[] srcArray, int des){
       int low=0;//最低下标
       int height=srcArray.length-1;//最高下标
       int middle=0;//中间下标
       while (low<=height){
           middle=(low+height)>>1;//等价于 low+(height-low)>>1
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

    /**
     * 二分查找第一个值等于给定值的元素
     * @param srcArray
     * @param des
     * @return
     */
    public static int binary_search_first(int[] srcArray,int des){
        int low=0;
        int height=srcArray.length-1;
        int middle=0;
        while (low<=height){
            middle=(low+height)>>1;
            if (des>srcArray[middle]){
                low=middle+1;
            }else if(des<srcArray[middle]){
                height=middle-1;
            }else{
                if (middle==0 || srcArray[middle-1]!=des){
                    return middle;
                }else{
                    height=middle-1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找最后一个个值等于给定值的元素
     * @param srcArray
     * @param des
     * @return
     */
    public static int binary_search_last(int[] srcArray,int des){
        int low=0;
        int height=srcArray.length-1;
        int middle=0;
        while (low<=height){
            middle=(low+height)>>1;
            if (des>srcArray[middle]){
                low=middle+1;
            }else if(des<srcArray[middle]){
                height=middle-1;
            }else{
                if (middle==0 || srcArray[middle+1]!=des){
                    return middle;
                }else{
                    low=middle+1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找第一个值大于等于给定值的元素
     * @param srcArray
     * @param des
     * @return
     */
    public static int binary_search_dayu(int[] srcArray,int des){
        int low=0;
        int height=srcArray.length-1;
        int middle=0;
        while (low<=height){
            middle=(low+height)>>1;
            if (srcArray[middle]>=des){
                if (middle==0 || srcArray[middle-1]<des){
                    return middle;
                }else{
                    height=middle-1;
                }
            }else{
                low=middle+1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param srcArray
     * @param des
     * @return
     */
    public static int binary_search_xiaoyu(int[] srcArray,int des){
        int low=0;
        int height=srcArray.length-1;
        int middle=0;
        while (low<=height){
            middle=(low+height)>>1;
            if (srcArray[middle]>des){
                height=middle-1;
            }else{
                if (middle==srcArray.length-1 || srcArray[middle+1]>des)
                    return middle;
                else
                    low=middle+1;
            }
        }
        return -1;
    }
}
