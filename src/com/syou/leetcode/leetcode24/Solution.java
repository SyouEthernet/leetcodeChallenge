package com.syou.leetcode.leetcode24;

import com.syou.leetcode.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 两两交换链表节点
        // 基本上可以看出来，使用双指针可以快速解决

        ListNode dummy = new ListNode();
        dummy.next = head;

        // l1之前的一个节点
        ListNode pre = dummy;

        ListNode l1 = dummy.next;
        // 空链表的情况
        if (l1 == null) {
            return head;
        }

        ListNode l2 = l1.next;
        // 链表只有一个节点的情况
        if (l2 == null) {
            return head;
        }

        do {
            swapNode(pre, l1, l2);
            pre = l1;
            l1 = l1.next;
            if (l1 == null) {
                break;
            }
            l2 = l1.next;
        } while (l2 != null);

        return dummy.next;
    }

    private void swapNode(ListNode pre, ListNode l1, ListNode l2) {
        System.out.println(l1.val);
        System.out.println(l2.val);
        ListNode temp = l2.next;
        pre.next = l2;
        l2.next = l1;
        l1.next = temp;
    }
}
