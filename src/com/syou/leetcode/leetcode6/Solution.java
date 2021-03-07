package com.syou.leetcode.leetcode6;

public class Solution {
    public String convert(String s, int numRows) {
        // 此题显示有规律，找到规律即可快速求出解
        // n = numRows - 1
        // i = 0        0n                               2n                             4n          ...      2n*j
        // i = 1        0n+1                1n+(n-1)     2n+1               3n+(n-1)                ...      2n*j+i 2n*j+n+(n-i)
        // i = 2        0n+2     1n+(n-2)                2n+2      3n+(n-2)                         ...      2n*j+i 2n*j+n+(n-i)
        // ...
        // i = n        1n                               3n                                         ...      2n*j+n

        if (numRows == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int n = numRows - 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            do {
                if (i == 0) {
                    int index = n * 2 * j;
                    if (index < s.length()) {
                        builder.append(charArray[index]);
                        j++;
                    } else {
                        break;
                    }
                } else if (i == n) {
                    int index = n * 2 * j + n;
                    if (index < s.length()) {
                        builder.append(charArray[index]);
                        j++;
                    } else {
                        break;
                    }
                } else {
                    int index = n * 2 * j - i;
                    if (index > 0 && index < s.length()) {
                        builder.append(charArray[index]);
                    }

                    index = n * 2 * j + i;
                    if (index < s.length()) {
                        builder.append(charArray[index]);
                        j++;
                    } else {
                        break;
                    }
                }
            } while (true);
        }
        return builder.toString();
    }
}
