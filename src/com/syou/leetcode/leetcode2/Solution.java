package com.syou.leetcode.leetcode2;

import com.syou.leetcode.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 链表操作，链表从低位到高位表示一个数字，然后我们需要求两个数字的加和，最终表示成为一个链表
        // 主要需要考虑进位，以及最后还有进位，链表长度还要增加的问题

        ListNode result = null;
        ListNode opListNode = null;
        // 进位判断
        boolean isAddOne = false;

        do {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int addSum = isAddOne ? num1 + num2 + 1 : num1 + num2;

            ListNode listNode = new ListNode(addSum % 10);
            isAddOne = addSum / 10 != 0;

            if (result == null) {
                // 初始赋值
                result = listNode;
                opListNode = result;
            } else {
                // 后接数字
                opListNode.next = listNode;
                // 后移
                opListNode = opListNode.next;
            }

            //l1 l2后移
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } while (l1 != null || l2 != null);

        // 遍历完两个数以后，再看看是否有进位，有进位再加一位
        if (isAddOne) {
            opListNode.next = new ListNode(1);
        }
        return result;
    }
}
