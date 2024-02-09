class Graph:

    def __init__(self, n: int, edges: List[List[int]]):
        self.n = n
        self.graph = defaultdict(list)
        self.weight = {}
        for edge in edges:
            u, v, w = edge[0], edge[1], edge[2]
            self.graph[u].append(v)
            self.weight[(u, v)] = w

    def addEdge(self, edge: List[int]) -> None:
        u, v, w = edge[0], edge[1], edge[2]
        self.graph[u].append(v)
        self.weight[(u, v)] = w

    def shortestPath(self, node1: int, node2: int) -> int:
        # use the dijkstra to find the shortest path
        if node1 == node2:
            return 0
        visited = set()
        min_heap = []
        heapify(min_heap)
        heappush(min_heap, (0, node1))
        # print(min_heap)
        while min_heap:
            weight_till_now, current_node = heappop(min_heap)
            if current_node == node2:
                return weight_till_now
            if current_node in visited:
                continue
            visited.add(current_node)
            # check all the neighbors of current_node
            # and if they are not visited add to the heap
            for neighbor in self.graph[current_node]:
                if neighbor in visited:
                    continue
                new_weight = weight_till_now + self.weight[(current_node, neighbor)]                
                heappush(min_heap, (new_weight, neighbor))
            # print (min_heap)
        return -1


# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)