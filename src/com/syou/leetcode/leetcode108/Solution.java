package com.syou.leetcode.leetcode108;

import com.syou.leetcode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 将一个有序数组转化为二叉搜索树
        // 其实类似与二分查找的使用，奇数数组取中间值
        // 偶数数组取前面的值，按照逻辑处理即可
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(nums, start, middle - 1);
        node.right = sortedArrayToBST(nums, middle + 1, end);
        return node;
    }
}
