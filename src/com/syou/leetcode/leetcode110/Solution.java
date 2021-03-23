package com.syou.leetcode.leetcode110;

import com.syou.leetcode.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        // 判断一个二叉树是不是平衡二叉树，平衡二叉树的每个叶子节点深度差不大于1

        // 空节点先判断
        if (root == null) {
            return true;
        }
        int leftLevel = maxDepth(root.left, 1);
        int rightLevel = maxDepth(root.right, 1);
        return leftLevel != 0 && rightLevel != 0 && Math.abs(leftLevel - rightLevel) <= 1;
    }


    private int maxDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        level++;
        int leftLevel = maxDepth(node.left, level);
        int rightLevel = maxDepth(node.right, level);
        if (leftLevel == 0 || rightLevel == 0 || Math.abs(leftLevel - rightLevel) > 1) {
            return 0;
        }

        return Math.max(leftLevel, rightLevel);
    }
}
