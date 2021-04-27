package com.syou.leetcode.leetcode268;

import java.util.Arrays;

public class Solution {
    public int missingNumber(int[] nums) {
        // 给一个长度为n的数组，但是数组中缺了0-n中的一个数
        // 使用O(n)的时间复杂度和O(1)的空间复杂度找出缺少的数字
        // 高斯求和
        int length = nums.length;
        long sum = Arrays.stream(nums).sum();
        long realSum = (long) (1 + length) * length / 2;
        return (int) (realSum - sum);
    }
}
