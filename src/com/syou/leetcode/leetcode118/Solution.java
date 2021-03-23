package com.syou.leetcode.leetcode118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Pascal三角形，由于numRows的最大取值为30，直接迭代获取即可
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                result.add(list);
                continue;
            }
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
