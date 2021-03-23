package com.syou.leetcode.leetcode202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        // 判断一个数是不是happynumber
        // happynumber就是把各位的平方加和，如果最后能为1，就是happynumber
        // 否则就不是
        // 这里直接循环递归调用即可，但是需要增加一个set来记录下数字，遇到重复的数字，
        // 那么就算进入死循环了，需要退出
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }

    private boolean isHappy(int n, Set<Integer> set) {
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        int result = 0;
        while(n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        if (result == 1) {
            return true;
        }
        return isHappy(result, set);
    }
}
