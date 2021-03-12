package com.syou.leetcode.leetcode1528;

public class Solution {
    public String restoreString(String s, int[] indices) {
        // 使用一个Char数组，轻松解决
        char[] charArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[indices[i]] = s.charAt(i);
        }

        return String.valueOf(charArray);
    }
}
