# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        def height(current_node):
            if current_node is None:
                return 0
            return 1 + max(height(current_node.left), height(current_node.right))
        ans = height(root)
        # find the first node that you can find at x level from left
        # to right
        def find_first_node_in_level(current_node, level):
            if current_node is None:
                return None
            if level == ans:
                return current_node.val
            left_ans = find_first_node_in_level(current_node.left, level + 1)
            if left_ans is not None:
                return left_ans
            right_ans = find_first_node_in_level(current_node.right, level + 1)
            return right_ans
        return find_first_node_in_level(root, 1)