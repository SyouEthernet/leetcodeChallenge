package com.syou.leetcode.leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // candidates和target都为正数
        // 我们在遍历数组的时候，只需要遍历到candidates[i] <= target即可
        // 需要注意先对数组排序
        int[] sorted = Arrays.stream(candidates).sorted().toArray();
        return findSum(sorted, target, 0);
    }

    private List<List<Integer>> findSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (target == candidates[i]) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(candidates[i]);
                result.add(tempList);
                continue;
            }
            List<List<Integer>> lists = findSum(candidates, target - candidates[i], i);
            if (!lists.isEmpty()) {
                for (List<Integer> list: lists) {
                    list.add(candidates[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
