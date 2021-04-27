package com.syou.leetcode.leetcode371;

public class Solution {
    public int getSum(int a, int b) {
        // 不使用+ -运算求两数的和
        // 那么只能使用位运算了
        // 我们知道两数求和的一个公式是((a&b)<<1)+(a^b)
        // 用一个循环去处理，直到（a&b）<<1为0

        while(b != 0) {
            int xor = a^b;
            int carry = (a&b) << 1;

            b = carry;
            a = xor;
        }

        return a;
    }
}
