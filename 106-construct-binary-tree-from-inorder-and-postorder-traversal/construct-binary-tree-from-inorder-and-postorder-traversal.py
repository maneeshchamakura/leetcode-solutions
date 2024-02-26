# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        post_index = len(postorder) - 1
        def build_tree(current_inorder):
            nonlocal post_index
            if postorder == -1 or len(current_inorder) == 0:
                return None
            curr_val = postorder[post_index]
            post_index -= 1
            current_root = TreeNode(curr_val)
            curr_index = current_inorder.index(curr_val)
            left_inorder = current_inorder[:curr_index]
            right_inorder = current_inorder[curr_index + 1:]
            current_root.right = build_tree(right_inorder)
            current_root.left = build_tree(left_inorder)
            return current_root
        return build_tree(inorder)
