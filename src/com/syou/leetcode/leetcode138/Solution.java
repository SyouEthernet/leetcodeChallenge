package com.syou.leetcode.leetcode138;

import java.util.HashMap;

public class Solution {
    public Node copyRandomList(Node node) {
        // 深度拷贝链表，这个链表上有两个指针，一个next指针指向下一个节点，一个random指针，指向随机节点
        // 问题点在于第二次的随机指针，如果遍历链表，耗时会过长，导致超时
        // 使用hashmap，在第一次生成节点时，对原链表和新链表进行映射
        HashMap<Node, Node> map = new HashMap<>();
        Node old = node;
        Node dummy = new Node(0);
        Node pre = dummy;

        // 第一遍，创建节点和处理next
        while(old != null) {
            Node n = new Node(old.val);
            pre.next = n;
            pre = n;
            map.put(old, n);
            old = old.next;
        }

        // 第二遍，处理random指针
        old = node;
        Node cur = dummy.next;
        while(old != null) {
            cur.random = map.get(old.random);
            cur = cur.next;
            old = old.next;
        }

        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
