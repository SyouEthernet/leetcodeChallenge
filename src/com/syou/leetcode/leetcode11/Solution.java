package com.syou.leetcode.leetcode11;

public class Solution {
    public int maxArea(int[] height) {
        // 能容纳水的多少，是由比较小的那个数决定的
        // 先取最两边的数，求个面积，然后看下左右两个数，哪个小就往中间移动，直到相遇
        int j = height.length - 1;
        int i = 0;
        int max = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
