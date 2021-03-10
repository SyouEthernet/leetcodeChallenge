package com.syou.leetcode.leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // 判断是否是有效到括号组合
        // 可以考虑使用栈来解
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (Character character :
                s.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (character != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
