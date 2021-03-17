package com.syou.leetcode.leetcode242;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        // 判断是否是Anagram，与leetcode49类似，比较简单，
        // 使用一个Hashmap，记录s字符串每个字母出现的次数
        // 对t字符串每个字母对应map中次数-1，
        // 最后我们判断下map中每个key的值是否都为0
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
