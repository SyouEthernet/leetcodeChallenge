package com.syou.leetcode.leetcode27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        // 移除数组中指定的元素val，移除以后返回数组的长度n，并且nums的前n个元素都没有元素val
        // 由于题目中限制了额外空间复杂度为O(1)，
        // 但是由于没有规定数组元素的顺序，
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            if (nums[j] == val) {
                j--;
                continue;
            }
            if (nums[i] == val) {
                swap(nums, i, j);
            }
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
