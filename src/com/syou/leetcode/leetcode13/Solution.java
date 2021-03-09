package com.syou.leetcode.leetcode13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        // int to roman 反向操作即可
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        List<String> list = new ArrayList<>();
        list.add("M");
        list.add("CM");
        list.add("D");
        list.add("CD");
        list.add("C");
        list.add("XC");
        list.add("L");
        list.add("XL");
        list.add("X");
        list.add("IX");
        list.add("V");
        list.add("IV");
        list.add("I");

        int result = 0;
        String string = s;
        for (String str : list) {
            while (string.startsWith(str)) {
                result += map.get(str);
                string = string.substring(string.indexOf(str) + str.length());
            }
        }
        return result;
    }
}
