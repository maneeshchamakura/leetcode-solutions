# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return
        dummy_root = TreeNode(-1)
        head = dummy_root
        def traverse(curr_node):
            nonlocal dummy_root
            if curr_node == None:
                return None
            left_node = curr_node.left
            right_node = curr_node.right
            dummy_root.right = curr_node
            curr_node.left = curr_node.right = None
            dummy_root = dummy_root.right
            # go on the left subtree
            traverse(left_node)
            traverse(right_node)
        traverse(root)
        return head.right