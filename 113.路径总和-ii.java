import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> visited = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return list;
    }

    void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        visited.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                list.add(new ArrayList<>(visited));
            }
        }

        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
        visited.removeLast();
    }
}
// @lc code=end

