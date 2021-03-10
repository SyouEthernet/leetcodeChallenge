package com.syou.leetcode.leetcode28;

public class Solution {
    public int strStr(String haystack, String needle) {
        // java可以直接调用String 的 indexOf方法，但是这显然不是想要的

        //判断下needle是否为空
        if (needle.isEmpty()) {
            return 0;
        }

        int i = 0;
        boolean isPartOf = false;

        for (; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && isPartOf(haystack.substring(i), needle)) {
                isPartOf = true;
                break;
            }
        }

        return isPartOf ? i : -1;

    }

    private boolean isPartOf(String haystack, String needle) {
        int i = 0;
        while(i < needle.length()) {
            if (haystack.charAt(i) != needle.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
