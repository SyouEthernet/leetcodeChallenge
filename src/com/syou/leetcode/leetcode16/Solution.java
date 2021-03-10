package com.syou.leetcode.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 先排序
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        int length = nums.length;
        int diff = Integer.MAX_VALUE;
        int closest = sortedArray[0] + sortedArray[1] + sortedArray[2];

        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int sum = sortedArray[i] + sortedArray[j] + sortedArray[k];
                int tempDiff = Math.abs(sum - target);
                if (tempDiff < diff) {
                    diff = tempDiff;
                    closest = sum;
                }
                if (sum < target) {
                    j++;
                } else if(sum > target){
                    k--;
                } else {
                    return closest;
                }
            }
        }
        return closest;
    }
}
