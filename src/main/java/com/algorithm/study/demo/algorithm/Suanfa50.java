package com.algorithm.study.demo.algorithm;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @Author: liuxun
 * @CreateDate: 2018/12/7 下午1:35
 * @Version: 1.0
 */
public class Suanfa50 {
    public static void main(String[] args) {
//        printMissingNumber(new int[]{1, 3, 6}, 6);
    }
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }


}
