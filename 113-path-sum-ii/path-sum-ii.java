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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        findPathSums(root, result, 0, sum, new ArrayList<>());
        return result;
    }
    public void findPathSums(TreeNode root, List<List<Integer>> result, int sumSoFar, int target, List<Integer> path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sumSoFar += root.val;
            path.add(root.val);
            if (sumSoFar == target) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        sumSoFar += root.val;
        path.add(root.val);
        findPathSums(root.left, result, sumSoFar, target, path);
        findPathSums(root.right, result, sumSoFar, target, path);
        path.remove(path.size() - 1);
    }
}