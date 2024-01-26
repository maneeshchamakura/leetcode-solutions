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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // find the node corresponding to x
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode xNode = null;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val == x) {
                xNode = temp;
                break;
            }
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        int leftCount = findNodesCount(xNode.left), rightCount=findNodesCount(xNode.right);
        int rem = n - leftCount - rightCount - 1;
        if (rem > leftCount + rightCount + 1 || leftCount > rem + rightCount + 1 || rightCount > rem+leftCount + 1) {
            return true;
        }
        return false;
    }
    public int findNodesCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int x1 = findNodesCount(root.left);
        int x2 = findNodesCount(root.right);
        return 1 + x1 + x2;
    }
}