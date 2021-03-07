package com.syou.leetcode.leetcode9;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(int x) {
        /* 第一种思路
        // 判断一个整数是不是palindrome
        // 首先，所有的负数都不是palindrome
        if (x < 0) {
            return false;
        }

        // 其次，可以考虑转化为字符数组解决，但是比较耗内存
        // 考虑使用一个栈来解
        // 先求出整数的长度
        int num = x;
        int length = 0;
        do {
            length++;
            num /= 10;
        } while (num != 0);

        // 如果长度为1，那就是palindrome
        if (length == 1) {
            return true;
        }

        // 从个位开始，把数字逐个放入栈中
        num = x;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        do {
            stack.push(num % 10);
            num /= 10;
            i++;
        } while (i < length / 2);
        // 如果长度是个奇数，那就再去掉一位
        if (length % 2 == 1) {
            num /= 10;
        }

        //开始弹出栈中数字进行对比
        do {
            if (stack.pop() != num % 10) {
                return false;
            }
            num /= 10;
        } while (!stack.empty());
        return true;
         */

        // 换一种思路，我们直接后半部分数字翻转，和前半部分数字进行对比，看下是否相等
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        // 0结尾的肯定不是palindrome
        if (x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        // 如果一个数字长度是奇数，那么reverse就会多一位，所以需要判断下reverse/10和x的大小关系
        return x == reverse || x == reverse / 10;
    }
}
