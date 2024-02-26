# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        # root
        # root.left and root.right
        max_sum_so_far = float("-inf")
        def max_sum(root):
            nonlocal max_sum_so_far
            if root == None:
                return 0
            # check the left node
            left_ans = max_sum(root.left)
            right_ans = max_sum(root.right)
            # try including only the current node, left_sum
            max_sum_so_far = max(max_sum_so_far, root.val + left_ans, root.val + right_ans)
            max_sum_so_far = max(max_sum_so_far, root.val + left_ans + right_ans, root.val)
            return max(root.val, left_ans + root.val, right_ans + root.val)
        max_sum(root)
        return max_sum_so_far
