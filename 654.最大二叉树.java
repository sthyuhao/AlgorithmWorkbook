/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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

//  解题思路：
//      本题难点在于如何寻找到数组中最大值的索引，找到索引后取得当前数组最大值作为根节点，然后将数组分割，递归调用以上步骤即可。
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    TreeNode maxTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int index = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        root.left = maxTree(nums, l, index - 1);
        root.right = maxTree(nums, index + 1, r);
        return root;
    }

    //找最大值的索引
    public int findMax(int[] nums, int l, int r){
        int max = Integer.MIN_VALUE;
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
// @lc code=end

