package com.syou.leetcode.leetcode21;

import com.syou.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 两个有序链表合为一个
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode pre = null;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (result == null) {
                    result = l1;
                    pre = result;
                } else {
                    pre.next = l1;
                    pre = pre.next;
                }
                l1 = l1.next;
            } else {
                if (result == null) {
                    result = l2;
                    pre = result;
                } else {
                    pre.next = l2;
                    pre = pre.next;
                }
                l2 = l2.next;
            }
            System.out.println(pre);
        }

        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }

        return result;
    }
}
