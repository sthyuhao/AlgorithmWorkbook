import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
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
//  二维数组有2^n - 1列
class Solution {
    int maxL = Integer.MIN_VALUE;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int sz = (int)(Math.pow(2, depth) - 1);
        for (int i = 0; i < depth; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < sz; j++) {
                list.add("");
            }
            res.add(list);
        }
        dfs(root, 0, 0, sz);
        return res;
    }

    void dfs(TreeNode root, int level, int left, int right) {
        if (root == null) {
            return;
        }
        List<String> list = res.get(level);
        list.set((left + right)/2, Integer.toString(root.val));

        level ++;
        dfs(root.left, level, left, (left + right)/2 - 1);
        dfs(root.right, level, (left + right)/2 + 1, right);
    }

    int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
// @lc code=end

