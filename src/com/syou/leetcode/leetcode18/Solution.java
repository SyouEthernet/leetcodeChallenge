package com.syou.leetcode.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 考虑排序后，先转化为3sum，然后再转化为2sum解决
        // 使用双指针方法解决
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int i = 0;
        while (i < sorted.length - 3 && sorted[i] * 4 <= target) {
            if (i > 0 && (sorted[i] == sorted[i - 1])) {
                i++;
                continue;
            }
            List<List<Integer>> lists = findThreeSum(sorted, i, sorted.length, target - sorted[i]);
            if (!lists.isEmpty()) {
                for (List<Integer> tempList : lists) {
                    tempList.add(sorted[i]);
                    result.add(tempList);
                }
            }

            i++;
        }

        return result;
    }

    private List<List<Integer>> findThreeSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int j = right - 1;
        while (left < j - 2 && nums[j] * 3 >= target) {
            if (j < right - 1 && (nums[j] == nums[j + 1])) {
                j--;
                continue;
            }
            System.out.println(j);
            List<List<Integer>> lists = findTwoSum(nums, left, j, target - nums[j]);
            if (!lists.isEmpty()) {
                for (List<Integer> tempList : lists) {
                    tempList.add(nums[j]);
                    result.add(tempList);
                }
            }
            j--;
        }
        return result;
    }

    private List<List<Integer>> findTwoSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int i = left + 1;
        int j = right - 1;
        while (i < j) {
            if (i > left + 1 && (nums[i] == nums[i - 1])) {
                i++;
                continue;
            }
            if (j < right - 1 && (nums[j] == nums[j + 1])) {
                j--;
                continue;
            }
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(nums[i]);
                tempList.add(nums[j]);
                lists.add(tempList);
                i++;
                j--;
            }
        }
        return lists;
    }
}
