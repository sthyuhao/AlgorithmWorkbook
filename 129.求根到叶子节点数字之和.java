import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        // 到达第二层时将上一层结果 * 10 再加上当前节点值
        int res = level * 10 + root.val;
        if (root.left == null && root.right == null) {
            return res;
        }
        
        return dfs(root.left, res) + dfs(root.right, res);
    }
}
// @lc code=end

