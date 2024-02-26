# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q= deque()
        q.append(root)
        result = []
        if root == None:
            return result
        i = 0
        while q:
            level = []
            sz = len(q)
            for _ in range(sz):
                node = q.popleft()
                level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if i % 2 == 1:
                level.reverse()
            result.append(level)
            i += 1
        return result