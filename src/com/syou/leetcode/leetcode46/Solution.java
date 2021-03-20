package com.syou.leetcode.leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 列出所有可能的排列结果
        // 由于nums中每个元素都是独特的，并且nums.length<6，因此可以考虑暴力回溯解法，时间复杂度为n方
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsArray = new ArrayList<>();
        for (int num : nums) {
            numsArray.add(num);
        }

        for (Integer num: numsArray) {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            List<Integer> tempNums = new ArrayList<>(numsArray);
            tempNums.remove(num);
            result.addAll(permute(list, tempNums));
        }
        return result;
    }

    private List<List<Integer>> permute(List<Integer> list, List<Integer> nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 0) {
            result.add(list);
        }
        for (Integer num : nums) {
            List<Integer> tempList = new ArrayList<>(list);
            List<Integer> tempNums = new ArrayList<>(nums);
            tempList.add(num);
            tempNums.remove(num);
            result.addAll(permute(tempList, tempNums));
        }

        return result;
    }
}
