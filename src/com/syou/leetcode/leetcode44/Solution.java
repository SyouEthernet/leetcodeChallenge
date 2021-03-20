package com.syou.leetcode.leetcode44;

import java.util.Arrays;

public class Solution {
    public boolean isMatch(String s, String p) {
        // 掩码匹配，使用动态规划解决
        // ? 可以表示任意单字符
        // * 可以表示任意长度的字符，包括空字符
        // 字符串里面可能存在多个*连续的情况，需要把这种转化为一个*
        if (p.length() == 0) {
            return s.length() == 0;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && p.charAt(i) == p.charAt(i - 1) && p.charAt(i) == '*') {
                continue;
            }
            builder.append(p.charAt(i));
        }
        String patten = builder.toString();
        boolean[][] dp = new boolean[s.length() + 1][patten.length() + 1];
        for (int i = 0; i < s.length() + 1; i++)
            Arrays.fill(dp[i], false);
        dp[0][0] = true;
        for (int i = 1; i < patten.length() + 1; i++) {
            if (patten.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= patten.length(); j++) {
                if (patten.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (patten.charAt(j - 1) == '?' || s.charAt(i - 1) == patten.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()] [patten.length()];
    }
}
