class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        # start with a node
        # put it in the first set
        set1 = set()
        set2 = set()
        n = len(graph)
        visited = set()
        def is_graph_bipartite(node):
            if node in visited:
                return True
            q = deque()
            q.append((node, 1))
            set1.add(node)            
            visited.add(node)
            while q:
                sz = len(q)
                for _ in range(sz):
                    current_node, current_set_no = q.popleft()
                    other_set_no = 2 if current_set_no == 1 else 1
                    current_set = set1 if current_set_no == 1 else set2
                    other_set = set1 if other_set_no == 1 else set2
                    for neighbor in graph[current_node]:
                        if neighbor in current_set:
                            return False
                        other_set.add(neighbor)
                        if neighbor not in visited:
                            q.append((neighbor, other_set_no))
                            visited.add(neighbor)
            return True
        for i in range(n):
            if not is_graph_bipartite(i):
                return False
        return True