package com.syou.leetcode.leetcode49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 尽可能使用hashtable，优化遍历检查过程
        List<List<String>> result = new ArrayList<>();
        // Map记录下字符串的加合，可以优化时间效率
        Map<Integer, List<List<String>>> map = new HashMap<>();
        for (String str : strs) {
            int sum = calculateSum(str);
            if (!map.containsKey(sum)) {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                List<List<String>> lists = new ArrayList<>();
                lists.add(tempList);
                map.put(sum, lists);
            } else {
                boolean isAlreadyGroup = false;
                for (List<String> list : map.get(sum)) {
                    if (isAnagram(list, str)) {
                        list.add(str);
                        isAlreadyGroup = true;
                        break;
                    }
                }
                if (!isAlreadyGroup) {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(str);
                    map.get(sum).add(tempList);
                }
            }
        }
        for (int i : map.keySet()) {
            result.addAll(map.get(i));
        }
        return result;
    }

    private int calculateSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 'a';
        }
        return sum;
    }

    private boolean isAnagram(List<String> list, String str) {
        String string = list.get(0);
        if (string.length() != str.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (!map.containsKey(string.charAt(i))) {
                return false;
            } else {
                map.put(string.charAt(i), map.get(string.charAt(i)) - 1);
            }
        }
        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
