package com.syou.leetcode.leetcode53;

public class Solution {
    public int maxSubArray(int[] nums) {
        // 使用动态规划解决
        // dp 代表包含从数组左边开始，包含当前下标元素的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
