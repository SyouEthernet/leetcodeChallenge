package com.syou.leetcode.leetcode101;

import com.syou.leetcode.TreeNode;

import java.util.Stack;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 判断一个树是否是镜像对称的
        // 以跟节点划分，判断左子树和右子树的值是否一样，再以此节点进一步判断
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null ^ q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
