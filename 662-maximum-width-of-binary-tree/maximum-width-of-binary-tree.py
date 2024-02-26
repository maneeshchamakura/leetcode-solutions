# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        q = deque()
        q.append((root, 1))
        max_width = 1
        while q:
            sz = len(q)
            curr_level = []
            for _ in range(sz):
                node, curr_val = q.popleft()
                curr_level.append(curr_val)
                if node.left:
                    q.append((node.left, 2*curr_val + 1))
                if node.right:
                    q.append((node.right, 2*curr_val + 2))
            if len(curr_level) >= 2:
                max_width = max(max_width, curr_level[-1] - curr_level[0] + 1)
        return max_width                