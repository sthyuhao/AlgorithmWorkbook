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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        helper(root, res);
        return res;
    }

    void helper(TreeNode root, int res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            
        }
    }
}
// @lc code=end

