package com.syou.leetcode.leetcode141;

import com.syou.leetcode.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // 判断一个链表是否有环
        // 很典型的一个使用快慢指针来解决的问题
        if (head == null) {
            return false;
        }

        ListNode p = head;
        ListNode q = head;

        while(q != null) {
            q = q.next;
            if (q == null) {
                break;
            }
            q = q.next;
            p = p.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}
