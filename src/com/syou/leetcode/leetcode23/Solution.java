package com.syou.leetcode.leetcode23;

import com.syou.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 由于题目没有限制不能新建链表，因此可以考虑把所有的节点的值加入到一个ArrayList中，排序后再构建一个新的链表
        ListNode result = null;
        if (lists.length == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }

        if (list.isEmpty()) {
            return result;
        }

        Collections.sort(list);

        ListNode pre = null;
        for (int i : list) {
            if (result == null) {
                result = new ListNode(i);
                pre = result;
                continue;
            }

            pre.next = new ListNode(i);
            pre = pre.next;
        }

        return result;
    }
}
