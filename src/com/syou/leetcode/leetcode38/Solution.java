package com.syou.leetcode.leetcode38;

public class Solution {
    public String countAndSay(int n) {
        // 数字1进行特殊处理，深下的进行对应处理即可
        String base = "1";
        if (n == 1) {
            return base;
        }

        String string = base;
        for (int i = 1; i < n; i++) {
            string = countAndSay(string);
        }
        return string;
    }

    private String countAndSay(String s) {
        StringBuilder builder = new StringBuilder();
        // 当前正在记录的字符
        char character = 0;
        // 出现的次数
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != character) {
                if (i > 0) {
                    // 出现字符不一致，也就是字符不一致的情况，将出现次数和字符加到builder的后面
                    builder.append(count);
                    builder.append(character);
                }
                count = 1;
                character = s.charAt(i);
            } else {
                count++;
            }
            i++;
        }
        builder.append(count);
        builder.append(character);
        return builder.toString();
    }
}
