class Solution:
    def countPairsOfConnectableServers(self, edges: List[List[int]], signalSpeed: int) -> List[int]:
        n = len(edges)+1
        adj = defaultdict(list)
        for a,b,w in edges:
            adj[a].append((b, w))
            adj[b].append((a, w))

        # DFS that returns number of connectable nodes
        # connectable means path to node from root is divisile by signalSpeed
        @cache
        def dfs(node, parent, path):   
            connectable = 1 if path == 0 else 0
            for neigh,w in adj[node]:
                if neigh == parent:
                    continue
                connectable += dfs(neigh, node, (path+w)%signalSpeed)
            return connectable

        ans = [0]*n
        for root in range(n):
            branches = adj[root]
            # For every pair of branches, multiply the options (# of connectable nodes)
            # dfs to get num of connectable options per branch of root (nodes are unique per branch)
            for i in range(len(branches)):
                a, aweight = branches[i]
                for j in range(i+1, len(branches)):
                    b, bweight = branches[j]
                    ans[root] += dfs(a, root, aweight%signalSpeed) * dfs(b, root, bweight%signalSpeed)
        return ans