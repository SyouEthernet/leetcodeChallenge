package com.syou.leetcode.leetcode42;

public class Solution {
    public int trap(int[] height) {
        // 这是一个典型到需要用双指针解决到题，
        // 从左到右走一遍，如果存在右边比左边小的就可以固定左边的点，
        // 当右边有比左边点高或这持平的，那就是右边的容器
        // 此外，还需要从右往左过一遍，确保不遗漏
        int i = 1;
        int left = 0;
        int total = 0;
        while(i < height.length) {
            if (height[i] >= height[left]) {
                total += area(height, left, i);
                left = i;
            }
            i++;
        }

        int right = height.length - 1;
        i = height.length - 2;
        while(i >= 0) {
            if (height[i] > height[right]) {
                total += area(height, i, right);
                right = i;
            }
            i--;
        }


        return total;
    }

    private int area(int[] height, int left, int right) {
        int area = 0;
        int high = Math.min(height[left], height[right]);
        for (int i = left + 1; i < right; i++) {
            area += high - height[i];
        }
        return area;
    }
}
