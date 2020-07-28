/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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

// 题目的意思是子节点需要用()来包裹。
// 举例来说，二叉树[root,left,right]，则转换为root(left)(right)。
// 如果只有left为空节点，则输出root()(right)；
// 如果只有right为空节点则可以忽略右节点的()，输出为root(left)。
class Solution {
    StringBuilder res = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        dfs(t);
        res.deleteCharAt(0);
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    void dfs(TreeNode t) {
        if (t == null) {
            return;
        }

        res.append("(");
        res.append(t.val);
        if (t.left == null && t.right != null) res.append("()");
        dfs(t.left);
        dfs(t.right);
        res.append(")");
    }
}
// @lc code=end

