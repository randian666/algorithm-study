package com.algorithm.study.demo.algorithm.leetcode;

/**
 * @author xun2.liu
 * @title: Solution24
 * @projectName algorithm-study
 * @description: 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * @date 2020/6/10 11:33
 */
public class Solution24 {
    /**
     * 解法： 双指针
     * 首先注意数组是有序的，那么重复的元素一定会相邻。
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     * 考虑用 2 个指针，一个在前记作 p1，一个在后记作 p2，算法流程如下：
     * 比较 p1 和 p2 位置的元素是否相等。
     * 如果相等，p2 后移 1 位
     * 如果不相等，将 p2 位置的元素复制到 p1+1 位置上，p1 后移一位，p2 后移 1 位
     * 重复上述过程，直到 p2 等于数组长度。
     * 返回 p1 + 1，即为新数组长度。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int p1=0;
        int p2=0;
        while(p2<nums.length){
            //如果不相等，将 p2 位置的元素复制到 p1+1 位置上，p1 后移一位，p2 后移 1 位
            if (nums[p1]!=nums[p2]){
                p1++;
                nums[p1]=nums[p2];
            }
            p2++;
        }
        return p1+1;
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 3}));
    }
}
