package com.syou.leetcode.leetcode48;

import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        // 顺时针旋转一个n x n的矩阵
        // 由于不能够重新创建矩阵，也就是意味着需要在原来的矩阵上操作
        // 如果矩阵是奇数阶，那么中间的那个点是不需要旋转的
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                int end = n - 1;
                matrix[i][j] = matrix[end - j][i];
                matrix[end - j][i] = matrix[end - i][end - j];
                matrix[end - i][end - j] = matrix[j][end - i];
                matrix[j][end - i] = temp;
                System.out.println(Arrays.deepToString(matrix));
            }
        }
    }
}
