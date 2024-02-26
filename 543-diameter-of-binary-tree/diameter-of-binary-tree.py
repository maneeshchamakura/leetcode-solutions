# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        max_diameter = 0
        def diameter(node):
            nonlocal max_diameter
            if node == None:
                return 0
            left_val = diameter(node.left)
            right_val = diameter(node.right)
            max_diameter = max(max_diameter, left_val + right_val + 1)
            return max(left_val, right_val) + 1
        diameter(root)
        return max_diameter - 1 if max_diameter > 0 else max_diameter