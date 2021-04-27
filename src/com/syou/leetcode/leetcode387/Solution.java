package com.syou.leetcode.leetcode387;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public int firstUniqChar(String s) {
        // 使用一个Hashmap去记录字符出现的次数
        // 再遍历一遍，如果对应hashmap中的值为1，则返回
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }
}
