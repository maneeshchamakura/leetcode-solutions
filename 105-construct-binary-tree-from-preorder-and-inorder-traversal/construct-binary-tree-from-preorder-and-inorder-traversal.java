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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(inorder, preorder, 0, preorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode newNode = new TreeNode(preorder[preIndex++]);
        if (start == end) return newNode;
        int index = search(inorder, newNode.val, start, end);
        newNode.left = buildTree(inorder, preorder, start, index-1);
        newNode.right = buildTree(inorder, preorder, index+1, end);
        return newNode;
    }
    public int search(int[] arr, int key, int start, int end) {
        for (int i=start; i<=end; i++) {
            if (key == arr[i]) return i;
        }
        return -1;
    }
}