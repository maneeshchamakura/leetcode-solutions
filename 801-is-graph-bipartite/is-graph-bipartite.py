class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        # start with a node
        # put it in the first set
        n = len(graph)
        set1, set2 = set(), set()
        visited = set()
        def is_graph_bipartite(node, parent_set_no):
            if node in visited:
                return True
            current_set_no = 2 if parent_set_no == 1 else 1
            current_set = set1 if current_set_no == 1 else set2
            current_set.add(node)
            visited.add(node)
            for neighbor in graph[node]:
                if neighbor in current_set:
                    return False
                if neighbor in visited:
                    continue
                is_valid = is_graph_bipartite(neighbor, current_set_no)
                if not is_valid:
                    return is_valid
            return True
            
        for i in range(n):
            if not is_graph_bipartite(i, 2):
                return False
        return True