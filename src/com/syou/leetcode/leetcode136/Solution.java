package com.syou.leetcode.leetcode136;

public class Solution {
    public int singleNumber(int[] nums) {
        // 找出数组中的单个元素，需要线性时间且不能使用额外空间
        // 即时间复杂度O(n)，空间复杂度O(1)
        // 可以使用异或运行来解决

        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
