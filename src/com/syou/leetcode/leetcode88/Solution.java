package com.syou.leetcode.leetcode88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将两个有序数组合并，最终的结果放在nums1中，考虑双指针解决
        // 先考虑m和n为0的情况
        if (n == 0) {
            return;
        }

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }

        // 然后双指针遍历
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);

        while (i < m || j < n) {
            if (i == m) {
                nums1[k] = nums2[j];
                j++;
                k++;
                continue;
            }
            if (j == n) {
                nums1[k] = nums3[i];
                i++;
                k++;
                continue;
            }
            if (nums2[j] <= nums3[i]) {
                nums1[k] = nums2[j];
                j++;
            } else {
                nums1[k] = nums3[i];
                i++;
            }
            k++;
        }
    }
}
