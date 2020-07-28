import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
//  用一个队列来记录节点位置即可
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        indexQ.offer(1);
        while (!queue.isEmpty()) {
            int left = indexQ.peek();
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                Integer index = indexQ.poll();
                res = Math.max(res, index - left + 1);
                if (node.left != null) {
                    queue.offer(node.left);
                    indexQ.offer(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQ.offer(index * 2 + 1);
                }
            }
        }
        return res;
    }
}
// @lc code=end

