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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        int height = height(root);
        // System.out.println(height);
        List<TreeNode> result = new ArrayList<>();
        result.add(root);
        lca(root, result, height, 1);
        return result.get(0);
    }
    
    public int lca(TreeNode root, List<TreeNode> result, int height, int level) {
        if (root == null) return -1;
        int left = lca(root.left, result, height, level + 1);
        int right = lca(root.right, result, height, level + 1);
        if (left == -1 && right == -1) {
            if (level == height) {
                result.set(0, root);
                return height;
            }
            return -1;
        }
        if (left != -1 && right != -1) {
            if (left == height && right == height) {                
                result.set(0, root);
                return height;
            }
            if (left == height || right == height) {
                return height;
            }
            return -1;
        } else if (left == -1) {
            return right;
        } else {
            return left;
        }
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}