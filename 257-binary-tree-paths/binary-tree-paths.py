# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        result = []
        if root == None:
            return result
        def root_to_leaf(root, prev):
            prev.append(str(root.val))
            if root.left == None and root.right == None:
                result.append('->'.join(prev))
                prev.pop()
                return            
            if root.left:
                root_to_leaf(root.left, prev)
            if root.right:
                root_to_leaf(root.right, prev)
            prev.pop()
        root_to_leaf(root, [])
        return result