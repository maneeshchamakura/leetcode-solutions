# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # preorder 3 9 20 15 7
        # inorder 9 3 15 20 7
        if len(preorder) == 0:
            return None
        pre_index = 0
        def build_tree(temp_inorder):
            nonlocal pre_index
            if len(temp_inorder) == 0 or pre_index == len(preorder):
                return None
            new_node = TreeNode(preorder[pre_index], None, None)
            index = temp_inorder.index(preorder[pre_index])
            pre_index += 1
            left_inorder = []
            if index > 0:
                left_inorder = temp_inorder[:index]
            right_inorder = []
            if index < len(temp_inorder) - 1:
                right_inorder = temp_inorder[index + 1:]
            new_node.left = build_tree(left_inorder)
            new_node.right = build_tree(right_inorder)
            return new_node
        return build_tree(inorder)