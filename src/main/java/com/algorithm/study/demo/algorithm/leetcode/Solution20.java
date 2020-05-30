package com.algorithm.study.demo.algorithm.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 */
public class Solution20 {

    /**
     * 任何数字跟自己进行异或都等于0，0跟任何数字异或都等于该数字本身。
     * 所以把数组中的数字进行异或最后得到的肯定是一个不重复的数字，因为重复的数字都是两两出现。
     * 公式：a^b^a=b
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        int result=0;
        for(int num:nums){
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }
}
