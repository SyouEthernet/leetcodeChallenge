package com.syou.leetcode.leetcode219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 相比217，增加了范围，如果使用暴力解法，时间复杂度比较高
        // 可以考虑使用hashset来记录一个元素是否出现
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 先移除超过范围的元素
            if (i - k > 0) {
                set.remove(nums[i - k - 1]);
            }

            // 判断是否包括重复
            if (set.contains(nums[i])) {
                return true;
            } else {
                // 将元素加入set
                set.add(nums[i]);
            }
        }
        return false;
    }
}
