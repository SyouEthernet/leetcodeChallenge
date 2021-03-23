package com.syou.leetcode.leetcode69;

public class Solution {
    public int mySqrt(int x) {
        // 求平方根方法，小数部分省区
        // 二分查找范畴

        //先处理两个特殊值
        if (x <= 1) {
            return x;
        }

        long left = 0;
        long right = x;
        long result = x / 2;
        do {
            if (result * result <= x && (result + 1) * (result + 1) > x) {
                break;
            }
            if (result * result > x) {
                right = result;
                result = (left + right) / 2;
            } else {
                left = result;
                result = (left + right) / 2;
            }
        } while(left < right);
        return (int) result;
    }
}
