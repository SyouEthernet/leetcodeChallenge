package com.syou.leetcode.leetcode169;

public class Solution {
    public int majorityElement(int[] nums) {
        // 求主要元素，主要元素指出现次数比n/2多， 要求线性时间复杂度和O(1)的空间复杂度
        // 如果不限制空间复杂度和时间复杂度，我们可以先通过hashmap记录每个数字出现的次数，
        // 由于限制来线性时间复杂度，也就是只能遍历一次数组，考虑摩尔投票法解决
        // 先假定第一个是结果，如果后续的元素和第一个相同，则计数+1，否则计数-1
        // 当计数为0的话，下一个元素就是假定为结果
        int result = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count > nums.length / 2) {
                break;
            }
            if (count == 0) {
                result = num;
                count = 1;
                continue;
            }
            if (result == num) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
