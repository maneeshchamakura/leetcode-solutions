class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        # find the shortest path starting from each node
        queue = []        
        visited = set()
        n = len(graph)
        if n == 1:
            return 0
        final_state = (1 << n) - 1        
        for i in range(n):
            queue.append((i, (0, (1 << i))))
            visited.add((i, (1 << i)))
        while queue:
            node, state_tuple = queue.pop(0)
            current_distance, current_state = state_tuple         
            for neighbor in graph[node]:
                new_state = current_state | (1 << neighbor)
                if new_state == final_state:
                    return current_distance + 1
                if (neighbor, new_state) in visited:
                    continue
                queue.append((neighbor, (1 + current_distance, new_state)))
                visited.add((neighbor, new_state))
        return -1