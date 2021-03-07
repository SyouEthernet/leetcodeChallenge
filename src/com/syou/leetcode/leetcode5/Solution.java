package com.syou.leetcode.leetcode5;

public class Solution {
    public String longestPalindrome(String s) {
        /* 由于s.length <= 1000, 可以考虑暴力解法
        String longest = "";

        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (isPalindrome(charArray, i, j)) {
                    longest = longest.length() < j - i ? s.substring(i, j) : longest;
                }
            }
        }

        return longest;
         */


        //同样可以考虑进行优化，找以i为中心的最长palindrome和以（i-1, i）为中心的最长palindrome
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String tempString = getLongestPalindrome(s, i);
            longest = longest.length() < tempString.length() ? tempString : longest;
        }

        return longest;
    }

    //找以i为中心的最长palindrome和以（i-1, i）为中心的最长palindrome
    private String getLongestPalindrome(String s, int i) {
        char[] charArray = s.toCharArray();
        String longestSingle = String.valueOf(charArray[i]);
        int left = i - 1;
        int right = i + 1;
        while (left >= 0 && right < charArray.length) {
            if (isPalindrome(charArray, left, right + 1)) {
                longestSingle = s.substring(left, right + 1);
                left--;
                right++;
            } else {
                break;
            }
        }

        String longestDouble = "";
        left = i - 1;
        right = i;
        while (left >= 0 && right < charArray.length) {
            if (isPalindrome(charArray, left, right + 1)) {
                longestDouble = s.substring(left, right + 1);
                left--;
                right++;
            } else {
                break;
            }
        }

        return longestSingle.length() > longestDouble.length() ? longestSingle : longestDouble;
    }


    private boolean isPalindrome(char[] charArray, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
