package com.syou.leetcode.leetcode191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 返回无符号整型中bit位为1的个数
        // 可以考虑位运算，也可以考虑除法，除法就需要考虑一下符号位
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 0x01) == 1) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}
