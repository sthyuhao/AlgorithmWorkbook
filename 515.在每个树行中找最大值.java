import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
        // return bfs(root);
    }

    void dfs(TreeNode root, List<Integer> list,int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(root.val);
        } else {
            list.set(level, Math.max(list.get(level), root.val));
        }
        
        level ++;
        dfs(root.left, list, level);
        dfs(root.right, list, level);
    }

    List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
// @lc code=end

