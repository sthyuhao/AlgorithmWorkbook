/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        if (p_start == p_end) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[p_end - 1]);
        Integer rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        int left = rootIndex - i_start;
        root.left = helper(inorder, i_start, rootIndex, postorder, p_start, p_start + left);
        root.right = helper(inorder, rootIndex + 1, i_end, postorder, p_start + left, p_end - 1);
        return root;
    }
}
// @lc code=end

