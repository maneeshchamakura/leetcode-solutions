# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        nums_so_far = set()
        self.present = False
        def traverse(current_node):
            if current_node is None:
                return
            traverse(current_node.left)
            current_val = current_node.val
            target = k - current_val
            if target in nums_so_far:
                self.present = True
            nums_so_far.add(current_val)
            traverse(current_node.right)
        traverse(root)
        return self.present