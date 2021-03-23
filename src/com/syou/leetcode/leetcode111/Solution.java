package com.syou.leetcode.leetcode111;

import com.syou.leetcode.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        // 获取一个二叉树的最小深度
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        level++;
        if (node.left == null && node.right == null) {
            return level;
        } else if (node.left == null) {
            return minDepth(node.right, level);
        } else if (node.right == null) {
            return minDepth(node.left, level);
        } else {
            return Math.min(minDepth(node.left, level), minDepth(node.right, level));
        }
    }
}
