# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def is_valid_bst(current_node, left_bound, right_bound):
            if current_node == None:
                return True
            if current_node.val >= left_bound and current_node.val <= right_bound:
                left_valid = is_valid_bst(current_node.left, left_bound, current_node.val - 1)
                if not left_valid:
                    return left_valid
                right_valid = is_valid_bst(current_node.right, current_node.val + 1, right_bound)
                return right_valid
            return False
        return is_valid_bst(root, float("-inf"), float("inf"))
