import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return list;
    }

    void helper(TreeNode root, String res) {
        if (root == null) {
            return;
        }

        res += root.val;
        if (root.left == null && root.right == null) {
            list.add(res);
            System.out.println(list);
        }
        res += "->";

        helper(root.left, res);
        helper(root.right, res);
    }
}
// @lc code=end

