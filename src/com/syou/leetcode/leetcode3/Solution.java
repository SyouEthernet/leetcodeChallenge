package com.syou.leetcode.leetcode3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 考虑使用一个int记录当前发现的最大长度
        // 使用一个队列 记录当前的内容
        int maxLength = 0;
        Queue<Character> maxString = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            // 如果maxString中包含了当前的字符，就从头部开始移除，直到队列里面没有字符为止
            while (maxString.contains(s.charAt(i))) {
                maxString.poll();
            }

            maxString.offer(s.charAt(i));
            maxLength = Math.max(maxLength, maxString.size());
        }

        return maxLength;
    }
}
