class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        n = len(edges)
        in_degrees = [0]*(n+1)
        for edge in edges:
            u, v = edge[0], edge[1]
            graph[u].append(v)
            in_degrees[v] += 1
        def is_valid():
            orig = in_degrees[1:]
            # check if one and only one node as in_degree 0
            zero_count = sum(1 for x in orig if x == 0)
            if zero_count == 1:
                # is every one reachable from 
                root_node = 1 + orig.index(0)
                queue = [root_node]
                visited = set()
                while queue:
                    size = len(queue)
                    while size > 0:
                        node = queue.pop(0)
                        visited.add(node)
                        for neighbor in graph[node]:
                            if neighbor in visited:
                                continue
                            queue.append(neighbor)
                        size -= 1
                return n == len(visited)  
            return False
        for edge in reversed(edges):
            # remove this edge
            u, v = edge[0], edge[1]
            graph[u].remove(v)
            in_degrees[v] -= 1
            # check if valid
            if is_valid():
                return edge
            # add back for next iteration
            graph[u].append(v)
            in_degrees[v] += 1
        return -1