package com.syou.leetcode.leetcode43;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        // 两个字符串表示的数字，计算他们的乘积
        // 不能使用内建的大数字库，也不允许直接把数字直接转化为integer
        // 当然，这个字符串的长度最大为200，直接转化肯定溢出
        // 使用印度多位数乘法解决
        int[][] array = new int[num1.length()][num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                array[i][j] = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder builder = new StringBuilder();
        int remain = 0;
        for (int j = num2.length() - 1; j >= 0; j--) {
            int sum = remain;
            for (int i = num1.length() - 1, k = j; i >= 0; i--) {
                sum += array[i][k] % 10;
                k++;
                if (k >= num2.length()) {
                    break;
                }
                sum += array[i][k] / 10;
            }
            builder.insert(0, sum % 10);
            remain = sum / 10;
        }

        for (int i = num1.length() -1; i >= 0 ; i--) {
            int sum = remain;
            for (int j = 0, k = i; j < num2.length(); j++) {
                sum += array[k][j] / 10;
                k--;
                if (k < 0) {
                    break;
                }
                sum += array[k][j] % 10;
            }
            builder.insert(0, sum % 10);
            remain = sum / 10;
        }

        while(remain != 0) {
            builder.insert(0, remain % 10);
            remain /= 10;
        }

        // 去掉头部的0
        while (builder.charAt(0) == '0' && builder.length() != 1) {
            builder.deleteCharAt(0);
        }

        return builder.toString();
    }
}
