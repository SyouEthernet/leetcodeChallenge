package com.syou.leetcode.leetcode15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 此问题是求出所有的组合，如果元素相同要算一个解法
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }

        // 排序
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();

        if (sortedArray[sortedArray.length - 1] < 0 || sortedArray[0] > 0) {
            return list;
        }

        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < sortedArray.length && sortedArray[i] <= 0; i++) {
            // 处理过的数字，不处理第二遍
            if (i > 0 && sortedArray[i] == sortedArray[i - 1]) {
                continue;
            }

            // 将可能的结果放入到List集合中
            map.put(sortedArray[i], findTwoSum(sortedArray, i, -sortedArray[i]));
        }

        for (int i : map.keySet()) {
            for (List<Integer> tempList : map.get(i)) {
                if (!tempList.isEmpty()) {
                    tempList.add(i);
                    list.add(tempList);
                }
            }
        }

        return list;
    }

    /*
    // 简单遍历
    private List<List<Integer>> findTwoSum(int[] nums, int i, int num) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int j = nums.length - 1; j > i && nums[j] >= 0; j--) {
            if (set.contains(nums[j])) {
                continue;
            }
            set.add(nums[j]);
            set.add(num - nums[j]);
            for (int k = j - 1; k > i && nums[k] >= num - nums[j] ; k--) {
                if (nums[k] == num - nums[j]) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    list.add(tempList);
                    // 找到元素，直接退出
                    break;
                }
            }
        }
        return list;
    }
     */

    //双指针接近
    private List<List<Integer>> findTwoSum(int[] nums, int i, int num) {
        List<List<Integer>> list = new ArrayList<>();
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                j++;
                continue;
            }
            if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                k--;
                continue;
            }
            if (nums[j] + nums[k] == num) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(nums[j]);
                tempList.add(nums[k]);
                list.add(tempList);
                j++;
                k--;
            } else if (nums[j] + nums[k] < num) {
                j++;
            } else {
                k--;
            }
        }
        return list;
    }
}
