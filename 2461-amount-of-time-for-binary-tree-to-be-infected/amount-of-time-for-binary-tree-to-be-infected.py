# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        # if the infection happens on the left subtree
        # and the infection happens on the right subtree
        max_time = float("-inf")
        def infect(root):
            nonlocal max_time
            # return (infected, height)
            if root is None:
                return (False, 0, 0)
            current_val = root.val
            is_current_start = False
            if current_val == start:
                # infected node
                is_current_start = True
            left_infected, left_height, left_delta = infect(root.left)
            right_infected, right_height, right_delta = infect(root.right)
            if not left_infected and not right_infected and is_current_start:
                max_time = max(max_time, left_height, right_height)
                return (True, 0, 1)
            if left_infected:
                max_time = max(max_time, left_delta + right_height)
                return (True, 0, left_delta + 1)
            elif right_infected:
                max_time = max(max_time, right_delta + left_height)
                return (True, 0, right_delta + 1)
            return (False, 1 + max(left_height, right_height), 0)
        infect(root)
        return max_time
