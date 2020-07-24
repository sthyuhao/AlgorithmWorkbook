/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int deep = 0;
    public int maxDepth(Node root) {
        dfs(root, 0);
        return deep;
    }

    void dfs(Node root, int level) {
        if (root == null) {
            return;
        }

        level ++;
        deep = Math.max(level, deep);
        for (Node node : root.children) {
            dfs(node, level);
        }
    }
}
// @lc code=end

