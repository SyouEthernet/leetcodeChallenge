package com.syou.leetcode.leetcode148;

import com.syou.leetcode.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public ListNode sortList(ListNode head) {
        // 单链表排序，需要O(nlogn)时间复杂度和O(1)的空间复杂度
        // 理论上讲需要用到快排

        // 快排，先找到一个基准，把所有比基准小的都扔到基准左边，把所有比基准大的扔到基准右边
        // 然后再分别对左边和右边进行快排，直到分区的个数为1
        // 但是快排存在极差情况，时间复杂度会退化到O(n2)

//        // 也可以使用优先级队列
//        if (head == null) {
//            return head;
//        }
//
//        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
//
//        ListNode node = head;
//        while(node != null) {
//            queue.add(node);
//            node = node.next;
//        }
//
//        ListNode res = queue.remove();
//        node = res;
//        while(!queue.isEmpty()) {
//            node.next = queue.remove();
//            node = node.next;
//        }
//        return res;

        // 也可以使用归并排序
        // 处理递归截止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        // 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while(left != null || right != null) {
            if (left == null) {
                node.next = right;
                break;
            }
            if (right == null) {
                node.next = left;
                break;
            }
            if (left.val <= right.val) {
                node.next = left;
                left = left.next;
                node = node.next;
            } else {
                node.next = right;
                right = right.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
