# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        def build_bst_from_free(temp_preorder):
            # start with the pre index
            # keep going in the preorder to the right 
            # until the sequence goes out of order
            if len(temp_preorder) == 0:
                return None
            root = TreeNode(temp_preorder[0])
            # find the rightmost point to insert the root.val
            index = bisect.bisect_right(temp_preorder, root.val)
            root.left = build_bst_from_free(temp_preorder[1:index])
            root.right = build_bst_from_free(temp_preorder[index:])
            return root
        return build_bst_from_free(preorder)
            