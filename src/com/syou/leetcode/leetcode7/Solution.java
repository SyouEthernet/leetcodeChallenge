package com.syou.leetcode.leetcode7;

class Solution {
    public int reverse(int x) {
        // 对整型进行翻转，主要就是考虑整型溢出问题，所以结果用long表示，方便后续判断
        long result = 0L;
        int a = Math.abs(x);

        // 负数标记
        boolean isNegetive = x < 0;

        //不停除10，取余运算
        while (a != 0) {
            result = result * 10 + a % 10;
            a /= 10;
        }

        // 负数处理
        if (isNegetive) {
            result = -result;
        }

        //int最大值最小值判断
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int)result;
    }
}
