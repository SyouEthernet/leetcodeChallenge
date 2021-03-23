package com.syou.leetcode.leetcode58;

public class Solution {
//    public int lengthOfLastWord(String s) {
//        // 字符串被空格分割成多个单词，返回最后一个单词的长度
//        // 直接按照题意进行处理即可
//        // 建立一个数组
//        String[] strings = s.split(" ");
//        // 空数组处理
//        if (strings.length == 0) {
//            return 0;
//        }
//        return strings[strings.length - 1].length();
//    }

    public int lengthOfLastWord(String s) {
        // 以上是借用java的split方法实现，如果不借用java的split方法,遍历字符即可
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (i == 0) {
                    length = 1;
                    continue;
                }
                if (chars[i - 1] == ' ') {
                    length = 1;
                    continue;
                } else {
                    length++;
                }
            }
        }
        return length;
    }

}
