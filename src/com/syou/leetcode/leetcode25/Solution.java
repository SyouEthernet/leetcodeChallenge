package com.syou.leetcode.leetcode25;

import com.syou.leetcode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 将链表按照k组进行翻转
        // 需要考虑使用递归解决
        if (k == 1) {
            return head;
        }

        return reverseK(head, k);
    }

    private ListNode reverseK(ListNode pre, int k) {
        if (pre == null) {
            return pre;
        }

        ListNode left = pre;
        ListNode right = left;
        int i = k - 1;
        while (i > 0) {
            right = right.next;
            if (right == null) {
                return left;
            }
            i--;
        }
        ListNode start = left;
        ListNode cur = left.next;
        do {
            ListNode temp = cur.next;
            cur.next = start;
            start = cur;
            cur = temp;
        } while (start != right);

        left.next = reverseK(cur, k);

        return start;
    }
}
