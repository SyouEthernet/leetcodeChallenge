package com.syou.leetcode.leetcode10;

public class Solution {
    public boolean isMatch(String s, String p) {
        //回溯算法可解
        return isRegularMatch(s, p);
    }

    private boolean isRegularMatch(String s, String p) {
        // 两者都为0，那么返回true
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }

        // s为空，但是p不为空且p的长度不为2，或者p长度为2，但是p[1]不为'*'，返回false
        if (s.isEmpty()) {
            if (p.length() < 2 || p.charAt(1) != '*') {
                return false;
            }
            return isRegularMatch(s, p.substring(2));
        }

        // p .*开头的，一种情况就是把.*去掉的p和s对比
        // 还有一种情况就是s去掉一位，p不变
        if (p.startsWith(".*")) {
            return isRegularMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
        }

        // p .开头的，s去掉一位，p去掉一位
        if (p.startsWith(".")) {
            return isRegularMatch(s.substring(1), p.substring(1));
        }


        // p 为字母开头的，我们判断字母后的一位是否为*
        // 如果为*，那就还是两种情况，一种情况就是把字母和*去掉的p和s对比
        // 还有一种情况就是s的首位是否相等，如果不等返回false，如果相等s去掉一位，p不变
        // 如果p 为字母开头，后一位不为*，先比较s和p的首字符是否相等，然后再s和p去掉一位，迭代后面的内容
        if (s.length() == 1 && p.length() == 1) {
            return s.equals(p);
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (s.charAt(0) == p.charAt(0)) {
                return isRegularMatch(s.substring(1), p) || isRegularMatch(s, p.substring(2));
            }
            return isRegularMatch(s, p.substring(2));
        }

        if (p.length() > 1 && p.charAt(1) != '*') {
            if (s.charAt(0) == p.charAt(0)) {
                return isRegularMatch(s.substring(1), p.substring(1));
            }
            return false;
        }

        return false;
    }
}
