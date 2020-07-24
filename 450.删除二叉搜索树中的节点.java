/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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

    public int rightMin(TreeNode root) {//1.找到以某个结点为根节点的右子树最小值。
		root = root.right;
		while (root.left != null) root = root.left;
		return root.val;
	}

	public int leftMax(TreeNode root) {//2.找到以某个结点为根节点的左子树最大值。
		root = root.left;
		while (root.right != null) root = root.right;
		return root.val;
	}

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            //  为叶子节点，直接删除即可
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = rightMin(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = leftMax(root);
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }
}
// @lc code=end

