package com.algorithm.study.demo.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 数组练习题
 * @Author: liuxun
 * @CreateDate: 2019/3/22 上午9:47
 * @Version: 1.0
 */
public class ArraySolution {

    public static void main(String[] args) {
        ArraySolution p=new ArraySolution();

        System.out.println(p.containsDuplicate(new int[]{1,2,3,1}));
    }

    /***
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{};
        }
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length==0 || nums.length==1){
            return true;
        }
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if (set.size()!=nums.length){
            return true;
        }
        return false;
    }
}
