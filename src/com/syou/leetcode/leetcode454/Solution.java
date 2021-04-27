package com.syou.leetcode.leetcode454;

import java.util.HashMap;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 在四个数组中各找一个数，使得四个数相加为0
        // 计算一共有几种组合
        // 两两一组，逐步解决

        int n = nums1.length;
        int result = 0;

        // key 代表 nums1 和 nums2 的结果， value表示出现次数
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (map1.containsKey(sum)) {
                    map1.put(sum, map1.get(sum) + 1);
                } else {
                    map1.put(sum, 1);
                }
            }
        }

        // key 代表 nums3 和 nums4 的结果， value表示出现次数
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                if (map2.containsKey(sum)) {
                    map2.put(sum, map2.get(sum) + 1);
                } else {
                    map2.put(sum, 1);
                }
            }
        }

        for (Integer i : map1.keySet()) {
            if (map2.containsKey(-i)) {
                result += map1.get(i) * map2.get(-i);
            }
        }

        return result;
    }
}
