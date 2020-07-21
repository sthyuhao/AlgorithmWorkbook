import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int rootIndex = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        int left = rootIndex - i_start;
        root.left = helper(preorder, p_start + 1, p_start + left + 1, inorder, i_start, rootIndex);
        root.right = helper(preorder, p_start + left + 1, p_end, inorder, rootIndex + 1, i_end);
        return root;
    }
}
// @lc code=end

