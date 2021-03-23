package com.syou.leetcode.leetcode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
//        // leetcode118的变化，思路一样，只是返回最后一行
//        List<Integer> result = new ArrayList<>();
//        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
//        for (int i = 0; i <= rowIndex; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    dp[i][j] = 1;
//                } else {
//                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                }
//                if (i == rowIndex) {
//                    result.add(dp[i][j]);
//                }
//            }
//        }
//        return result;

        // 但是题目需要优化到只使用O(rowIndex)的空间也就是说单纯在一个一位数组或list中操作
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        for (int i = 0; i <= rowIndex; i++) {
            result.add(dp[i]);
        }
        return result;
    }
}
