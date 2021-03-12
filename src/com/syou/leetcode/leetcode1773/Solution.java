package com.syou.leetcode.leetcode1773;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // 返回item中rulekey 符合 ruleValue的个数
        // 由于item中每个都是按照顺序去写的，即[type, color, name]，可以先创建个map

        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);

        int count = 0;
        int i = map.get(ruleKey);
        for (List<String> list: items) {
            if (list.get(i).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
