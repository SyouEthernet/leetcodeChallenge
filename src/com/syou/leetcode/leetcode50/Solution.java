package com.syou.leetcode.leetcode50;

class Solution {
    public double myPow(double x, int n) {
        // 直接进行乘法运算，会导致时间复杂度较高为O(n)
        // 使用递归来解决，能将时间复杂度降低到O(lgn)
        // 考虑幂为负数，负数时结果为负数绝对值的倒数
        boolean isNegetive = false;
        if (n < 0) {
            isNegetive = true;
        }
        return isNegetive ? 1 / fastPow(x, Math.abs(n)) : fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfn = n / 2;
        double xPowHalfn = fastPow(x, halfn);
        double result = xPowHalfn * xPowHalfn;

        // 不能被2整除时，增加一次相乘
        if (n % 2 != 0) {
            result = result * x;
        }
        return result;
    }
}
