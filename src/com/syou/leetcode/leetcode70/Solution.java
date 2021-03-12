package com.syou.leetcode.leetcode70;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int climbStairs(int n) {
        // 经典题目爬楼梯，斐波那契数列，使用递归能很快写出来
        // return n <= 2 ? n : climbStairs(n-1) + climbStairs(n-2);
        // 但是直接这么写，在性能上有问题，我们可以创建一个Map，对过程进行优化，或者使用动态规划解决

        /*创建一个map优化
        if (n <= 2) {
            return n;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return climb(map, n);
         */

        // 动态规划解法
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    /*创建一个map优化
    private int climb(Map<Integer, Integer> map, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = climb(map, n - 1) + climb(map, n - 2);
        map.put(n, result);
        return result;
    }
     */
}
