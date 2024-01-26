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
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        postOrderIndex = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode newNode = new TreeNode(postOrder[postOrderIndex--]);
        if (inStart == inEnd) {
            return newNode;
        }
        int index = search(inorder, newNode.val, inStart, inEnd);
        newNode.right = buildTree(inorder, postOrder, index+1,inEnd);
        newNode.left = buildTree(inorder, postOrder, inStart, index-1);
        return newNode;
    }
    public int search(int[] in, int val, int start, int end) {
        for (int i=start; i <= end; i++) {
            if (in[i] == val) return i;
        }
        return -1;
    }
}