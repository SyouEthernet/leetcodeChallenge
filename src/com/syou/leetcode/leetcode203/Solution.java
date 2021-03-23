package com.syou.leetcode.leetcode203;

import com.syou.leetcode.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 给一个链表，给一个val，移除链表中所有的值为val的节点，返回移除以后的头部
        // 这里可以考虑使用个dummyHead来处理

        // 判空
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
