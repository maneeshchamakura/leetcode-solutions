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
    int i=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        if(!checkTree(root, result, voyage)) {
            return Arrays.asList(-1);
        }
        return result;
    }
    
    public boolean checkTree(TreeNode root, List<Integer> nodes, int[] voyage) {
        if (root == null) return true;
        if (root.val !=  voyage[i]) return false;
        i++;
        if (root.left != null) {
            if (root.left.val != voyage[i]) {
                if (root.right == null || root.right.val != voyage[i]) return false;
                nodes.add(root.val);
                TreeNode left = root.left;
                root.left = root.right;
                root.right = left;
            }
            boolean res1 = checkTree(root.left, nodes, voyage);
            if (!res1) return false;            
        } 
        return checkTree(root.right, nodes, voyage);
    }
}