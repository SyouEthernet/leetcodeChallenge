package com.syou.leetcode.leetcode125;

import java.util.Locale;
import java.util.Stack;

public class Solution {
    public boolean isPalindrome(String s) {
        // 判断一个字符串是否是Palindrome，使用栈解决
        // 需要注意把所有字符转为小写,由于还存在空格和标点，需要把空格和标点都去掉
        String string = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z' || string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                builder.append(string.charAt(i));
            }
        }
        String stringABC = builder.toString();
        for (int i = 0; i < stringABC.length() / 2; i++) {
            stack.push(stringABC.charAt(i));
        }

        for (int i = (stringABC.length() + 1) / 2; i < stringABC.length(); i++) {
            if (stack.pop() != stringABC.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
