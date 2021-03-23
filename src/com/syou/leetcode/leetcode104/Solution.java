package com.syou.leetcode.leetcode104;

import com.syou.leetcode.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        // 计算一个二叉树的深入，直接使用深度优先算法解决
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        level++;
        return Math.max(maxDepth(root.left, level), maxDepth(root.right, level));
    }
}
