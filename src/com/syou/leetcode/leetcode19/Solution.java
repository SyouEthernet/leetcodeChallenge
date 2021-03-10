package com.syou.leetcode.leetcode19;

import com.syou.leetcode.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 从链表结尾移除第N个节点，
        // 链表不能像数组一样可以直观得到这个节点，所以需要遍历，
        // 比较暴力的方法是先遍历一遍链表，知道长度，然后再从头数一遍，
        // 本题还可以考虑使用双指针来优化时间复杂度

        // 创建一个虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        //创建快慢指针
        ListNode fast = dummy;
        ListNode slow = dummy;

        //快指针先向后移动n个
        int i = n;
        while (i > 0) {
            fast = fast.next;
            i--;
        }

        //快慢指针同时移动，直到快指针到了末尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 将慢指针的next指向下一指针的next，那么就完成了末尾第N个节点的移除，
        // 当然要考虑一种情况，就是可能移除的是头节点或者尾节点
        // 如果移除的是头节点，那就需要直接把头节点的指针指向头节点的next
        if (slow.next == head) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }

        return head;
    }
}
