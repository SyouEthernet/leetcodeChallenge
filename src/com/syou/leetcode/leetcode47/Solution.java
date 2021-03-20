package com.syou.leetcode.leetcode47;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 和leetcode46类似，但是这次有重复元素
        // 我们单独创建一个数组，来标记这个数字有没有使用过
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int[] visited = new int[nums.length];
        return permute(new ArrayList<>(), sorted, visited);
    }

    private List<List<Integer>> permute(List<List<Integer>> lists, int[] nums, int[] visited) {
        if (lists.size() != 0 && lists.get(0).size() == nums.length) {
            return lists;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            // 核心判断逻辑如下
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] != 1) {
                continue;
            }
            List<List<Integer>> tempLists = new ArrayList<>();
            int[] tempVisited = visited.clone();
            tempVisited[i] = 1;
            if (lists.size() != 0) {
                for (List<Integer> list : lists) {
                    List<Integer> tempList = new ArrayList<>(list);
                    tempList.add(nums[i]);
                    tempLists.add(tempList);
                }
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(nums[i]);
                tempLists.add(tempList);
            }
            result.addAll(permute(tempLists, nums, tempVisited));
        }
        return result;
    }
}
