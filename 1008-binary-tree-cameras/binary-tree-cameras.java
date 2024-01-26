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
    int cameraCount = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        isCameraNeeded(root, null);
        return cameraCount;
    }
    
    public boolean isCameraNeeded(TreeNode root, TreeNode parent) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (parent != null) {
                return true;
            } else {
                root.val++;
                cameraCount++;
                return false;
            }
        }
        TreeNode left = root.left;
        if (left != null) {
            boolean res1 = isCameraNeeded(left, root);
            if (res1) {
                root.val++;
                cameraCount++;
            }
        }
        TreeNode right = root.right;
        if (right != null) {
            boolean res2 = isCameraNeeded(right, root);
            if (res2 && root.val == 0) {
                root.val++;
                cameraCount++;                
            }
        }
        if (root.val != 0) return false;
        if ((left != null && left.val != 0) || (right != null && right.val != 0)) {
            return false;
        }
        if (parent == null) {
            cameraCount++;
            return false;
        }
        return true;
    }
}