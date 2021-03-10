package com.syou.leetcode.leetcode22;

import com.syou.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>[][] dp = new ArrayList[n + 1][n + 1];

        dp[0][0] = new ArrayList<>();
        dp[0][0].add("");

        for (int x = 1; x < n + 1; x++) {
            for (int y = 0; y < n + 1; y++) {
                if (y > x) {
                    break;
                }
                if (y == 0) {
                    dp[x][y] = new ArrayList<>();
                    for (String str : dp[x-1][0]) {
                        dp[x][y].add(str + "(");
                    }
                }else if (x == y) {
                    dp[x][y] = new ArrayList<>();
                    for (String str : dp[x][y-1]) {
                        dp[x][y].add(str + ")");
                    }
                } else {
                    dp[x][y] = new ArrayList<>();
                    for (String str : dp[x][y-1]) {
                        dp[x][y].add(str + ")");
                    }
                    for (String str : dp[x-1][y]) {
                        dp[x][y].add(str + "(");
                    }
                }
            }
        }
        return dp[n][n];
    }
}
