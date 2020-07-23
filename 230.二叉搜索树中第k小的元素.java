import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k-1);
    }

    //  二叉搜索树中序遍历的结果就是一个升序的数组，然后取index即可
    void inOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
// @lc code=end

