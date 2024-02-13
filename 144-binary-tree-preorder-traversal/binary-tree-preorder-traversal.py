# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        preorder_list = []
        def pre_order(root):
            if root == None:
                return
            preorder_list.append(root.val)
            pre_order(root.left)
            pre_order(root.right)
        pre_order(root)
        return preorder_list