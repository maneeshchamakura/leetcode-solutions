"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return node
        nodes = {}
        q = deque()
        q.append(node)
        visited = set()
        visited.add(node)
        while q:
            sz = len(q)
            for _ in range(sz):
                current_node = q.popleft()
                if current_node.val not in nodes:
                    nodes[current_node.val] = Node(current_node.val)
                new_node = nodes[current_node.val]
                # add all the neighbors to the queue
                # and to the neighbors list
                for neighbor in current_node.neighbors:
                    if neighbor.val not in nodes:
                        nodes[neighbor.val] = Node(neighbor.val)
                    new_neighbor = nodes[neighbor.val]
                    new_node.neighbors.append(new_neighbor)
                    if neighbor not in visited:
                        q.append(neighbor)
                        visited.add(neighbor)
        return nodes[node.val]