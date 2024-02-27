# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # find point where you split away
        # or where you find one node but the other is at the bottom
        def find_ancestor(current_node, val1, val2):
            if current_node == None:
                return None
            current_val = current_node.val
            if current_val == val2 or current_val == val1:
                return current_node
            if val1 < current_val and val2 < current_val:
                return find_ancestor(current_node.left, val1, val2)
            if val1 > current_val and val2 > current_val:
                return find_ancestor(current_node.right, val1, val2)
            return current_node
        return find_ancestor(root, p.val, q.val)