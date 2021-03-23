package com.syou.leetcode.leetcode122;

public class Solution {
    public int maxProfit(int[] prices) {
        // 和leetcode121相似，但是可以多次买卖
        // greedy
        int maxProfit = 0;
        if (prices.length == 1) {
            return maxProfit;
        }

        int i = 0;
        int j = 1;
        while (j < prices.length) {
            if (j == prices.length - 1) {
                if (prices[j] - prices[i] > 0) {
                    maxProfit += prices[j] - prices[i];
                }
                break;
            }
            if (i == j) {
                j++;
                continue;
            }
            if (prices[i] >= prices[j]) {
                i = j;
                continue;
            }
            if (prices[j + 1] >= prices[j]) {
                j++;
            } else {
                maxProfit += prices[j] - prices[i];
                i = j;
            }
        }
        return maxProfit;
    }
}
