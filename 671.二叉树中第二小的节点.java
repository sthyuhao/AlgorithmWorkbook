/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//  子节点的值>=跟节点的值，所以最小的肯定是根节点的
class Solution {
    long res = Long.MAX_VALUE;
    int rootV;
    public int findSecondMinimumValue(TreeNode root) {
        rootV = root.val;
        helper(root);
        if (res == Long.MAX_VALUE) return -1;
        return (int) res;
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (rootV != root.val) {
            res = Math.min(res, root.val);
        }

        helper(root.left);
        helper(root.right);
    }
}
// @lc code=end

