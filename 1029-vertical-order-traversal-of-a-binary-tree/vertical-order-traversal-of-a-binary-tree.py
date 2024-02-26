# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        vertical_order = defaultdict(list)
        result = []
        if root == None:
            return result
        q = deque()
        q.append((root, 0))
        min_val = 0
        while q:
            sz = len(q)
            temp_dict = defaultdict(list)
            for _ in range(sz):
                node, index = q.popleft()
                min_val = min(min_val, index)
                temp_dict[index].append(node.val)
                if node.left:
                    q.append((node.left, index - 1))
                if node.right:
                    q.append((node.right, index + 1))
            for key, val in temp_dict.items():
                vertical_order[key].extend(sorted(val))
        while min_val in vertical_order:
            result.append(vertical_order[min_val])
            min_val += 1
        return result