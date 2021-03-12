package com.syou.leetcode.leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 与leetcode39类似，只是不能重复使用数组元素，我们把对应的元素剔出即可
        int[] sorted = Arrays.stream(candidates).sorted().toArray();
        return findSum(sorted, target, 0);
    }

    private List<List<Integer>> findSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            // 剔除位置不同，但是内容相同的重复元素
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(candidates[i]);
                result.add(tempList);
                continue;
            }
            // 剔除位置不同的元素，因此此处的start要改为i + 1
            List<List<Integer>> lists = findSum(candidates, target - candidates[i], i + 1);
            if (!lists.isEmpty()) {
                for (List<Integer> list : lists) {
                    list.add(candidates[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
