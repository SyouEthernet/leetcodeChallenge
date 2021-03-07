package com.syou.leetcode.leetcode8;

public class Solution {
    public int myAtoi(String s) {
        // 经典题目atoi，需要考虑的边界条件比较多
        // 当使用long类型的时候，比较好解
        int length = s.length();
        long result = 0L;
        // 操作指针
        int i = 0;
        boolean isPositive = true;

        if (length == 0) {
            return 0;
        }

        // 将头部空格去掉
        while (i < length && s.charAt(i) == ' ') {
            i++;
        }

        // 判断下是否存在正负号
        if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            isPositive = s.charAt(i) == '+';
            i++;
        }

        // 向后取数字进行判断
        while (i < length && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }

        return isPositive ? (int)result : (int)result * -1;
    }
}
