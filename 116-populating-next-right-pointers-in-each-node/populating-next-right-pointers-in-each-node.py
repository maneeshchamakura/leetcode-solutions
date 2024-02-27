"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def sub_connect(curr_node, next_node):
            if curr_node == None:
                return
            curr_node.next = next_node
            if curr_node.left == None and curr_node.right == None:
                return
            sub_connect(curr_node.left, curr_node.right)
            sub_connect(curr_node.right, next_node if next_node is None else next_node.left)
        sub_connect(root, None)
        return root