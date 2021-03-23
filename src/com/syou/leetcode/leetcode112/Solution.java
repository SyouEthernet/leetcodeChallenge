package com.syou.leetcode.leetcode112;

import com.syou.leetcode.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 判断是否有根到叶子节点之和为targetSum
        // 由于targetSum和node.val均能取负值，因此不能简单地进行剪枝

        //空节点处理
        if (root == null) {
            return false;
        }

        // 是叶子节点的逻辑
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
