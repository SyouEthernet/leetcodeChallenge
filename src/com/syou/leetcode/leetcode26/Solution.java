package com.syou.leetcode.leetcode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        // 把所有重复的元素移动到数组尾部去，使用双指针解决
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] < nums[j]) {
                swap(nums, i + 1, j);
                i++;
            }
            j++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
