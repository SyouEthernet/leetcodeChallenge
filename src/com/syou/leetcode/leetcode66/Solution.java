package com.syou.leetcode.leetcode66;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] plusOne(int[] digits) {
        // 数组末位加一，主要需要考虑进位问题
        // 以及可能会增加数组长度
        // 将数组转化为arraylist就比较好操作了
        List<Integer> list = new ArrayList<>(digits.length);
        for (int i : digits) {
            list.add(i);
        }

        // 定义一个变量记录进位
        boolean addOne = false;
        if (list.get(digits.length -1) == 9) {
            list.set(digits.length -1, 0);
            addOne = true;
        } else {
            list.set(digits.length -1, list.get(digits.length -1) + 1);
        }
        for (int i = digits.length -2; i >= 0 ; i--) {
            if (!addOne) {
                break;
            }
            int num = list.get(i);
            if (num == 9) {
                list.set(i, 0);
            } else {
                list.set(i, num + 1);
                addOne = false;
            }
        }

        // 如果最后还有进位，那就往list前面再加1
        if (addOne){
            list.add(0, 1);
        }

        // 最后转化为int数组
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
