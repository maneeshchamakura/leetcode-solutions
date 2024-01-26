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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (low > high) return 0;
        int current_val = root.val;
        if (current_val < low) {
            // current node value is less than the left boundary
            return rangeSumBST(root.right, low, high);
        } else if (current_val > high) {
            // current node value is greater than the right boundary
            // go to the left subtree
            return rangeSumBST(root.left, low, high);
        } else {
            // now the current node value is within range
            int res = current_val;
            res += rangeSumBST(root.left, low, current_val - 1);
            res += rangeSumBST(root.right, current_val + 1, high);
            return res;
        }
    }
}