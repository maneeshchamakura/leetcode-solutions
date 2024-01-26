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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenUtil(root);
    }
    public TreeNode flattenUtil(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode rootLeft = root.left;
        TreeNode rootRight = root.right;
        TreeNode lastLeftNode = flattenUtil(rootLeft);
        TreeNode lastRightNode = flattenUtil(rootRight);
        if (lastLeftNode == null) {
            // don't need to do anything
            return lastRightNode;
        } else if (lastRightNode == null) {
            root.right = rootLeft;
            root.left = null;
            return lastLeftNode;
        } else {
            lastLeftNode.right = rootRight;
            root.left = null;
            root.right = rootLeft;
            return lastRightNode;
        }
    }
}