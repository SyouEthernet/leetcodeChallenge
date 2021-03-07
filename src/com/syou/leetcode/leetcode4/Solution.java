package com.syou.leetcode.leetcode4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 找到两个已经排序过的数组的中位数
        // 如果两个数组中的元素总个数为奇数，那么中位数就是数组中的某一个特定的值
        // 如果两个数组中的元素总个数为偶数，那么中位数就是中间两个数的平均数
        // 由于-10^6 <= nums1[i], nums2[i] <= 10^6, 不存在溢出问题
        // 同时限制了时间复杂度需要为O(log(m+n))
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        // 如果有个数组为空，那就等于在另一个数组中找中位数
        if (nums1.length == 0) {
            return findMedianInSingleArray(nums2);
        }
        if (nums2.length == 0) {
            return findMedianInSingleArray(nums1);
        }

        int checked = 0;
        int i = 0;
        int j = 0;
        if ((nums1.length + nums2.length) % 2 == 0) {
            int small;
            int big;
            // 总元素为偶数的逻辑
            do {
                if (i == nums1.length) {
                    small = nums2[j + (nums1.length + nums2.length) / 2 - checked - 1];
                    big = nums2[j + (nums1.length + nums2.length) / 2 - checked];
                    return calculateDoubleMean(small, big);
                }
                if (j == nums2.length) {
                    small = nums1[i + (nums1.length + nums2.length) / 2 - checked - 1];
                    big = nums1[i + (nums1.length + nums2.length) / 2 - checked];
                    return calculateDoubleMean(small, big);
                }

                if (nums1[i] < nums2[j]) {
                    small = nums1[i];
                    i++;
                } else {
                    small = nums2[j];
                    j++;
                }
                checked++;
            } while (checked < (nums1.length + nums2.length) / 2);
            if (i == nums1.length) {
                big = nums2[j];
                return calculateDoubleMean(small, big);
            }
            if (j == nums2.length) {
                big = nums1[i];
                return calculateDoubleMean(small, big);
            }
            if (nums1[i] < nums2[j]) {
                big = nums1[i];
            } else {
                big = nums2[j];
            }
            return calculateDoubleMean(small, big);
        } else {
            // 总元素为奇数的逻辑
            int median;
            do {
                if (i == nums1.length) {
                    return nums2[j + (nums1.length + nums2.length) / 2 - checked];
                }
                if (j == nums2.length) {
                    return nums1[i + (nums1.length + nums2.length) / 2 - checked];
                }
                if (nums1[i] < nums2[j]) {
                    median = nums1[i];
                    i++;
                } else {
                    median = nums2[j];
                    j++;
                }
                checked++;
            } while (checked <= (nums1.length + nums2.length) / 2);
            return median;
        }
    }

    private double findMedianInSingleArray(int[] nums) {
        if (nums.length % 2 == 0) {
            // 偶数个元素
            int a = nums[nums.length / 2 - 1];
            int b = nums[nums.length / 2];
            return calculateDoubleMean(a, b);
        } else {
            // 奇数个元素
            return nums[nums.length / 2];
        }
    }

    private double calculateDoubleMean(int a, int b) {
        return ((double) a + (double) b) / 2;
    }
}
