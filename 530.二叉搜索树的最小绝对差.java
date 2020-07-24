import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (pre != null) {
            res = Math.min(Math.abs(root.val - pre.val), res);
        }
        pre = root;
        dfs(root.right);
    }
}
// @lc code=end

