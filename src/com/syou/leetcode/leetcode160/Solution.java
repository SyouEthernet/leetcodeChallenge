package com.syou.leetcode.leetcode160;

import com.syou.leetcode.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 找到两个链表相交的节点，不能破坏原链表的结构
        // 两个链表相交，那么必然后面有一部分是重叠的，从后往前读相同部分即可
        // 使用两个栈来保存两个链表各个节点，再同时弹栈即可
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode listNodeA = headA;
        ListNode listNodeB = headB;
        ListNode result = null;
        while (listNodeA != null) {
            ListNode temp = listNodeA;
            stackA.push(temp);
            listNodeA = listNodeA.next;
        }
        while (listNodeB != null) {
            ListNode temp = listNodeB;
            stackB.push(temp);
            listNodeB = listNodeB.next;
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            if (nodeA != nodeB) {
                break;
            }
            result = nodeA;
        }
        return result;
    }
}
