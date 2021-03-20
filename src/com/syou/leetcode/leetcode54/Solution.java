package com.syou.leetcode.leetcode54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        while (i < (m + 1) / 2 && i < (n + 1) / 2) {
            if (i == m / 2) {
                for (int j = i; j < n - i; j++) {
                    list.add(matrix[i][j]);
                }
                i++;
                continue;
            }
            if (i == n / 2) {
                for (int j = i; j < m - i; j++) {
                    list.add(matrix[j][i]);
                }
                i++;
                continue;
            }

            // 四条边
            for (int j = i; j < n - 1 - i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i; j < m - 1 - i; j++) {
                list.add(matrix[j][n - 1 - i]);
            }
            for (int j = n - 1 - i; j > i; j--) {
                list.add(matrix[m - 1 - i][j]);
            }
            for (int j = m - 1 - i; j > i; j--) {
                list.add(matrix[j][i]);
            }

            i++;
        }
        return list;
    }
}
