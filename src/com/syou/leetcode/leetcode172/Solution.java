package com.syou.leetcode.leetcode172;

public class Solution {
    public int trailingZeroes(int n) {
        // 给定一个数n，求n!阶乘结果中尾部0的个数
        // 要求时间复杂度为O(logn)
        // 末尾的0比较好统计，2*5= 10增加个0 10会增加个0
        // 实际上，由于偶数比5 多，只要出现一个5，那么就会出现一个末尾0；
        // 当出现5*5时，会出现两个末尾0
        // 出现5*5*5时，会出现3个末尾0
        // 因此计算如下

        int result = 0;
        while(n != 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
