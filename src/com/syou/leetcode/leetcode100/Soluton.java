package com.syou.leetcode.leetcode100;

import com.syou.leetcode.TreeNode;

public class Soluton {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断两个树是否相同，前序遍历即可

        if (p == null && q == null) {
            return true;
        }

        if (p == null ^ q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
