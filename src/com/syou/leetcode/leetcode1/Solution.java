package com.syou.leetcode.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 从一个数组中找出两个数，加和为target，由于数组并不是有序到，因此正向遍历与反向均可
        // 由于数组中到数字和target可以为负数，因此不能够通过大小判断来提高效率
        // 可以考虑使用一个HashMap来存储 （target - 当前值）和（当前值的下标 ），
        // 然后在下次判断的时候直接判断HashMap中是否包含这个key即可

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}
