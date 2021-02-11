package com.syou.leetcode.leetcode220;

import java.util.TreeMap;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 此问题如果使用暴力遍历解法，将导致超时
        // 另外需要注意，nums的值需要转成long类型, 如果使用int类型进行加减运算，会导致整型溢出
        // 使用TreeMap能很快解决
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 从数组中把超出范围的元素移除
            if (i - k > 0) {
                int value = treeMap.get((long) nums[i - k - 1]);
                if (value > 1) {
                    treeMap.put((long) nums[i - k - 1], value - 1);
                } else {
                    treeMap.remove((long) nums[i - k - 1]);
                }
            }

            // 判断下数组中有没有满足条件的元素，如果存在，就返回true
            if (i > 0) {
                Long key = treeMap.lowerKey((long) nums[i] + t + 1);
                if (key != null && key >= (long) nums[i] - t) {
                    return true;
                }
            }

            // 判断一下，把数组元素放入treemap中
            if (treeMap.containsKey((long) nums[i])) {
                treeMap.put((long) nums[i], treeMap.get((long) nums[i]) + 1);
            } else {
                treeMap.put((long) nums[i], 1);
            }
        }
        return false;
    }
}
