package com.syou.leetcode.leetcode190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 翻转bit位, 需要将n 作为一个无符号的值
        // 单纯的位移操作
        // 由于int为32bit因此需要移动32次
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 0x01;
            n = n >> 1;
            result = (result << 1) + temp;
        }
        return result;
    }
}
