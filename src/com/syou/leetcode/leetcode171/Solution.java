package com.syou.leetcode.leetcode171;

public class Solution {
    public int titleToNumber(String columnTitle) {
        // 和 leetcode168类似，不过是反过来的,
        // 字符串转化为数字
        // 比之前的转化容易多了
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
