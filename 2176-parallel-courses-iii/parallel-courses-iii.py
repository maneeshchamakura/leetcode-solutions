class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        max_time = {}
        graph = defaultdict(list)
        for relation in relations:
            u, v = relation[0], relation[1]
            graph[u].append(v)
        def dfs(src):
            if src in max_time:
                return max_time[src]
            res = time[src-1]
            for nei in graph[src]:
                res = max(res, time[src - 1] + dfs(nei))
            max_time[src] = res
            return res
        for i in range(1, n + 1):
            dfs(i)
        return max(max_time.values())        