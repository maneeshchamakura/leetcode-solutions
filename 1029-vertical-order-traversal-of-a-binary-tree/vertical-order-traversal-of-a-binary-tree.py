# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from functools import cmp_to_key
from sortedcontainers import SortedList
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        nodes_position = {}
        def traverse(root, x, y):
            key = (x, y)
            if root is None:
                return
            sorted_list = nodes_position.get(key, SortedList())
            sorted_list.add(root.val)
            nodes_position[key] = sorted_list
            traverse(root.left, x + 1, y - 1)
            traverse(root.right, x + 1, y + 1)
        traverse(root, 0, 0)
        nodes_items = list(nodes_position.items())        
        def sort_function(key1, key2):
            x1, y1, x2, y2 = key1[0][0], key1[0][1], key2[0][0], key2[0][1]
            if y1 == y2:
                if x1 < x2:
                    return -1
                return 1
            if y1 < y2:
                return -1
            return 1
        nodes_items.sort(key=cmp_to_key(sort_function))
        print(nodes_items)
        result = []
        # merge the elements belonging to the same column
        index = 0
        n = len(nodes_items)
        while index < n:
            current_col = nodes_items[index][0][1]
            current_list = []
            current_list.extend(nodes_items[index][1])
            index += 1
            while index < n and nodes_items[index][0][1] == current_col:
                current_list.extend(nodes_items[index][1])
                index += 1
            result.append(current_list)
        return result
