package com.syou.leetcode.leetcode31;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public void nextPermutation(int[] nums) {
        // 这道题需要理清思路再解
        // 第一种情况如果此数组已经是由大到小排列了，那么下一个Permutation就是由小到大排列
        // 第二种情况是需要找到一个i，nums[i - 1] < nums[i]
        // 那么就需要将nums[i - 1] 和 nums[i]及右侧的数据比较，
        // 取出一个刚好比nums[i - 1]大的数，与nums[i - 1]交换位置，
        // 然后nums[i]与右侧的数据重新按照从小到大来排序
        if (nums.length <= 1) {
            return;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int i = nums.length - 1;
        for (; i >= 0; i--) {
            treeMap.put(nums[i], i);
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, treeMap.get(treeMap.higherKey(nums[i])));
                treeMap.remove(nums[i]);
                sortArray(nums, i + 1);
                break;
            }
        }
        if (i == -1) {
            sortArray(nums, 0);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void sortArray(int[] nums, int start) {
        Arrays.sort(nums, start, nums.length);
    }
}
