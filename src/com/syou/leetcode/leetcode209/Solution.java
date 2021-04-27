package com.syou.leetcode.leetcode209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 给定一个数组，要求找出合大于等于target的最小长度子数组
        // 没有的话返回0，有的话返回数组长度；
        // 滑动窗口解决
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = nums[end];
        while (start <= end) {
            if (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            } else {
                end++;
                if (end < nums.length) {
                    sum += nums[end];
                } else {
                    break;
                }
            }
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
