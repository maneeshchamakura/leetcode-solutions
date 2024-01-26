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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maximum(root);
        return max;
    }
    public int maximum(TreeNode root) {
        if (root == null) return 0;        
        int leftSum = maximum(root.left);
        int rightSum = maximum(root.right);
        int current = root.val;
        max = Math.max(max, Math.max(current, Math.max(leftSum, rightSum) + current));
        max = Math.max(max, current + leftSum + rightSum);
        return Math.max(current, Math.max(leftSum, rightSum) + current);
    }
}