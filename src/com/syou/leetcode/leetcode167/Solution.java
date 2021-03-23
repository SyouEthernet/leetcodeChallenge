package com.syou.leetcode.leetcode167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 相比较leetcode1，此处的数组是有序的
        // 而且需要返回的是在数组中的顺序（下标 + 1）
        // 使用双指针接近很容易解决,由于数组中有负数的情况存在，因此不能进行右裁剪
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
            if (numbers[i] + numbers[j] <= target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
