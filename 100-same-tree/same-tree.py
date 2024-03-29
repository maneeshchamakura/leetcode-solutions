# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        def checkSame(root1, root2):
            if root1 == None and root2 == None:
                return True
            if root1 == None or root2 == None:
                return False
            if root1.val != root2.val:
                return False
            ans = checkSame(root1.left, root2.left)
            if not ans:
                return ans
            return checkSame(root1.right, root2.right)
        return checkSame(p, q)
