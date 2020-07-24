import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return res;
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        //  判断节点是否为左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        helper(root.left);
        helper(root.right);
    }
}
// @lc code=end

