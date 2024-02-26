# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # do BFS and find the level order traversal
        level_order = []
        if root == None:
            return []
        q = deque()
        q.append(root)
        while q:
            sz = len(q)
            level = []
            for _ in range(sz):
                node = q.popleft()
                level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            level_order.append(level)
        return [sub_list[-1] for sub_list in level_order]