from typing import List
from collections import defaultdict


class Solution:
    def maxOutput(self, n: int, edges: List[List[int]], price: List[int]) -> int:
        graph = defaultdict(list)
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        def dfs(node, parent=-1):
            current_price = price[node]
            max_output = (0, current_price, 0)

            for neighbor in graph[node]:
                if neighbor == parent:
                    continue

                neighbor_output = dfs(neighbor, node)
                combined_output = (
                    max(
                        max_output[0],
                        neighbor_output[0],
                        max_output[1] + neighbor_output[2],
                        max_output[2] + neighbor_output[1],
                    ),
                    max(max_output[1], neighbor_output[1] + current_price),
                    max(max_output[2], neighbor_output[2] + current_price),
                )

                max_output = combined_output

            return max_output

        if n <= 2:
            return sum(price) - min(price)

        for node in range(n):
            if len(graph[node]) > 1:
                return dfs(node)[0]