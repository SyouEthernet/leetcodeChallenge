package com.syou.leetcode.leetcode168;

public class Solution {
    public String convertToTitle(int columnNumber) {
        // 将列表数转化为excel的标题字符串
        // A = 1
        // Z = 26
        // AA = 26 * 1 + 1
        // AB = 26 * 1 + 2
        // AZ = 26 * 1 + 26
        // ZZ = 26 * 26 + 26
        // AAA = 26 * 26 * 1 + 26 * 1 + 1
        StringBuilder builder = new StringBuilder();
        int number = columnNumber;
        while (number != 0) {
            if (number <= 26) {
                builder.insert(0, (char) ('A' + number - 1));
                break;
            } else {
                if (number % 26 == 0) {
                    builder.insert(0, 'Z');
                    number = (number - 26) / 26;
                } else {
                    builder.insert(0, (char) ('A' + number % 26 - 1));
                    number /= 26;
                }
            }
        }
        return builder.toString();
    }
}
