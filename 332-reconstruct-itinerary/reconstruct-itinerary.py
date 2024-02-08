class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = DefaultDict(list)
        for ticket in tickets:
            from_dest, to_dest = ticket[0], ticket[1]
            adj[from_dest].append(to_dest)
        for val_list in adj.values():
            val_list.sort()
        ans = []
        def helper(node):
            while adj[node]:
                helper(adj[node].pop(0))
            ans.append(node)
        helper("JFK")
        return reversed(ans)