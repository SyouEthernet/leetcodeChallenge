package com.syou.leetcode.leetcode45;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int jump(int[] nums) {
        // 构造一个和nums相同的数组，然后使用贪心算法从后往前遍历即可
        int[] steps = new int[nums.length];
        steps[steps.length - 1] = 0;
        for (int i = steps.length - 2; i >=0 ; i--) {
            if (nums[i] == 0) {
                steps[i] = Integer.MAX_VALUE;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < steps.length && j <= nums[i] + i; j++) {
                min = Math.min(min, steps[j]);
            }
            if (min == Integer.MAX_VALUE) {
                steps[i] = Integer.MAX_VALUE;
                continue;
            }
            steps[i] = min + 1;
        }
        System.out.println(Arrays.toString(steps));
        return steps[0];
    }
}
