package com.syou.leetcode.leetcode234;

import com.syou.leetcode.ListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        /* 思路一
        // 和leetcode9 思路类似
        // 先求出链表总长度，然后用堆栈解决
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length ++;
            p = p.next;
        }

        if (length == 1) {
            return true;
        }

        // 构建堆栈
        int i = 0;
        p = head;
        Stack<Integer> stack = new Stack<>();
        do {
            stack.push(p.val);
            p = p.next;
            i++;
        }while (i < length/2);

        // 如果长度是奇数，往后移动一个数
        if (length % 2 == 1) {
            p = p.next;
        }

        // 开始弹出栈
        do {
            if (p.val != stack.pop()) {
                return false;
            }
            p = p.next;
        }while (!stack.empty());

        return true;
        */

        // 换一种思路，可以使用双指针来解决
        // 先找到中间节点，然后把中间节点之后到节点翻转，再进行对比就可以了

        ListNode dummy = new ListNode(0);
        ListNode fastListNode = new ListNode(0);
        ListNode slowListNode = new ListNode(0);
        dummy.next = head;
        fastListNode.next = head;
        slowListNode.next = head;

        while (fastListNode.next != null) {
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next;
            fastListNode = fastListNode.next;
            if (fastListNode == null) {
                break;
            }
        }

        // 长度为1的情况
        if (slowListNode.next == null) {
            return true;
        }

        reverseListNode(slowListNode);

        do {
            dummy = dummy.next;
            slowListNode = slowListNode.next;
            if (dummy.val != slowListNode.val) {
                return false;
            }
        } while (slowListNode.next != null);
        return true;
    }

    private void reverseListNode(ListNode node) {
        ListNode p = node.next;
        ListNode q = p.next;
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        node.next.next = null;
        node.next = p;
    }
}
