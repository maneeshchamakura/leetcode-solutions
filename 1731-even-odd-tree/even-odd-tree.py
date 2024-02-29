# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        level = 0
        q = deque()
        q.append(root)
        def is_sorted(arr, increasing):
            compare_val = 1 if increasing else 0         
            for num in arr:
                if num % 2 != compare_val:
                    return False
            if increasing:
                for i in range(len(arr) - 1):
                    # compare i and i + 1
                    if arr[i] < arr[i+1]:
                        continue
                    return False
            else:
                for i in range(len(arr) - 1):
                    # compare i and i + 1
                    if arr[i] > arr[i+1]:
                        continue
                    return False
            return True
        while q:
            sz = len(q)
            current_level = []
            for _ in range(sz):
                node = q.popleft()
                current_level.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            print (current_level)
            if not is_sorted(current_level, level % 2 == 0):
                return False
            level += 1
        return True

