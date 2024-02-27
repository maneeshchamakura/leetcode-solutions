# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root == None:
            return root
        current_val = root.val
        if current_val == val:
            return root
        if current_val > val:
            return self.searchBST(root.left, val)
        return self.searchBST(root.right, val)