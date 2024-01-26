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
    public int amountOfTime(TreeNode root, int start) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        traverse(root, start, result);
        return result.get(0);
    }
    
    public int[] traverse(TreeNode root, int start, List<Integer> result) {
        if (root == null) return new int[]{0, 0};
        int[] left = traverse(root.left, start, result);
        int[] right = traverse(root.right, start, result);
        if (left[1] == -1) {
            if (left[0]> result.get(0)) {
                result.set(0, left[0]);
            }
            if (right[0] != 0 && right[0] + left[0]> result.get(0)) {
                result.set(0, right[0] + left[0]);
            }
            return new int[]{left[0] + 1, -1};
        } else if (right[1] == -1) {
            if (right[0]> result.get(0)) {
                result.set(0, right[0]);
            }
            if (left[0] != 0 && right[0] + left[0]> result.get(0)) {
                result.set(0, right[0] + left[0]);
            }
            return new int[]{right[0] + 1, -1};
        } else {
            int max_len = Math.max(left[0], right[0]);
            if (root.val == start) {
                result.set(0, max_len);
                return new int[]{1, -1};
            }
            return new int[]{max_len + 1, 0};
        }
    }
}