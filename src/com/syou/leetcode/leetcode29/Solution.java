package com.syou.leetcode.leetcode29;

public class Solution {
    public int divide(int dividend, int divisor) {
        // 不使用乘/除/取模运算实现一个相除函数
        // 需要考虑整型溢出问题
        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        // 结果是否是负数
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        long m = dividend;
        long n = divisor;
        m = Math.abs(m);
        n = Math.abs(n);

        long result = 0;
        while (m >= n) {
            long t = n;
            long p = 1;
            while (m >= (t << 1)) {
                t = t << 1;
                p = p << 1;
            }
            result += p;
            m -= t;
        }
        return (int) (isNegative ? result : -result);
    }
}
