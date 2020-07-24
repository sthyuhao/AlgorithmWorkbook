import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    int deep = Integer.MIN_VALUE;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        // return bfs(root);

        dfs(root, 0);
        return res;
    }

    //  dfs遍历就完事了，每层都只记录最左边的节点
    void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > deep) {
            deep = level;
            res = root.val;
        }

        level ++;
        dfs(root.left, level);
        dfs(root.right, level);
    }
    
    int bfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            TreeNode node = queue.peek();
            if (node != null) {
                res = node.val;
            }            
        }
        return res;
    }
}
// @lc code=end

