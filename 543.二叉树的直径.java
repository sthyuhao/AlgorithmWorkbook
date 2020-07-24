import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    LinkedList<Integer> list = new LinkedList<>();
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        System.out.println(res);
        return res;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left + right > res) {
            res = left + right;
        }
        return Math.max(right, left) + 1;
    }
}
// @lc code=end

