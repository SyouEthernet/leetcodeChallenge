package com.syou.leetcode.leetcode121;

import java.util.Arrays;
import java.util.OptionalInt;

public class Solution {
    public int maxProfit(int[] prices) {
        // 给一个数组，表示股票的价格，只买卖一次，算出最大收益
        // 首先明确一点，我们在最小值处买，最大值处卖出，此时的收益最大
        // 但是如果最大值在最小值的之前发生了，那么就不能这么算了，
        // 需要找到最大值之前的最小值和最小值之后的最大值求差，然后两差取大值
        // 特殊情况，最大值在最左边，最小值在最右边，这种情况需要在中间找找看
        // 使用动态规划解决dp[i]表示prices[0]到prices[i]的最小值
        if (prices.length == 1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        int maxProfit = 0;
        dp[0] = prices[0];
        for (int i = 1; i < dp.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - dp[i - 1]);
            dp[i] = Math.min(dp[i-1], prices[i]);
        }
        return maxProfit;
    }
}
