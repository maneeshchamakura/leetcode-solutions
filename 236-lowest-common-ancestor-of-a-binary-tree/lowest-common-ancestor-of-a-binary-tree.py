# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        stored = False
        ancestor = ""
        def traverse(node, p, q):
            nonlocal stored, ancestor
            if node == None:
                return False
            found_on_left = traverse(node.left, p, q)
            found_on_right = traverse(node.right, p, q)
            if found_on_left and found_on_right and not stored:
                stored = True
                ancestor = node
                return False
            if node == p or node == q:
                if found_on_left or found_on_right:
                    stored = True
                    ancestor = node
                    return False
                else:
                    return True
            return found_on_left or found_on_right
        traverse(root, p, q)
        return ancestor
