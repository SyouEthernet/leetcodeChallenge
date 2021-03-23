package com.syou.leetcode.leetcode83;

import com.syou.leetcode.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 从链表中移除重复节点
        // 空链表判断
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        while(pre.next != null) {
            ListNode cur = pre.next;
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }

        return head;
    }
}
