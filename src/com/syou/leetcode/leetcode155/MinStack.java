package com.syou.leetcode.leetcode155;

import java.util.Stack;

/**
 * 设计一个最小栈，除了可是实现栈的基本功能外，还能返回栈中的最小值
 * 使用两个栈来实现，一个用来保存具体数值，另一个用来保存值到最小值到差值
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        // 入栈到时候需要注意，如果是空栈，直接入栈一个val，并且helper入栈一个0，因为当前val就是最小
        // 如果栈不为空，拿到栈中最小值，比对，如果比最小值大，最小值不变，顺便计算需要入栈helper到值，
        // 如果比最小值小，val入栈stack，并且helper入栈个0
        if (stack.isEmpty()) {
            stack.push(val);
            helper.push(0);
        } else {
            int min = getMin();
            if (val < min) {
                stack.push(val);
                helper.push(0);
            } else {
                stack.push(val);
                helper.push(val - min);
            }
        }
    }

    public void pop() {
        // 需要弹栈到时候两个一起弹出
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.peek() - helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
