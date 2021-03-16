package com.syou.leetcode.leetcode41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        // 这道题要求使用O(n)的时间复杂度和O(1)的空间复杂度来解决
        // 但是由于提示中告诉我们O(2n) == O(n)
        // 因此，其实我们可以考虑，先过一遍数组，把对应的n值，移动到数组到n-1下标
        // 然后再过一遍数组，发现nums[n-1] != n即可

        int maxOrder = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                maxOrder = i + 1;
            } else {
                break;
            }
        }
        return maxOrder + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
