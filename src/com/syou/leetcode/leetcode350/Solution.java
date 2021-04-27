package com.syou.leetcode.leetcode350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 可以考虑将两个数组进行排序后解决
        // 也可以考虑使用一个hashmap对一个数组进行保存，然后再遍历另一个数组
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                result.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
