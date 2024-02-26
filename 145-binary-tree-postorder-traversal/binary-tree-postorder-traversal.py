# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        inorder, preorder, postorder = [], [], []
        if root == None:
            return postorder
        stack = []
        stack.append((root, 1))
        while stack:
            current_node, val = stack.pop()
            if val == 1:
                preorder.append(current_node.val)
            elif val == 2:
                inorder.append(current_node.val)
            else:
                postorder.append(current_node.val)
            if val != 3:
                stack.append((current_node, val + 1))
            if val == 1 and current_node.left:
                # add the left child if it exists
                stack.append((current_node.left, 1))
            if val == 2 and current_node.right:
                # add the right child if it exists
                stack.append((current_node.right, 1))
        return postorder
            