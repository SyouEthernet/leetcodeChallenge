package com.syou.leetcode.leetcode14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // 找到长度最短的字符串
        int minLength = Integer.MAX_VALUE;
        String minString = strs[0];
        for (String str : strs) {
            if (str.length() < minLength) {
                minString = str;
                minLength = str.length();
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (!isValidPrefix(strs, minString.substring(0, i + 1))) {
                break;
            } else {
                builder.append(minString.charAt(i));
            }
        }

        return builder.toString();
    }

    private boolean isValidPrefix(String[] strs, String prefix) {
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
