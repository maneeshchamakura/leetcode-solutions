class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        ans = [[0]*n for _ in range(n)]
        for query in queries:
            r1, c1 = query[0], query[1]
            r2, c2 = query[2], query[3]
            ans[r1][c1] += 1
            if c2 + 1 < n:
                ans[r1][c2 + 1] -= 1
            if r2 + 1 < n:
                ans[r2 + 1][c1] -= 1
            if r2 + 1 < n and c2 + 1 < n:
                ans[r2 + 1][c2 + 1] += 1
        # add the prefix sum along the column
        for i in range(n):
            for j in range(1, n):
                ans[i][j] += ans[i][j-1]
        for j in range(n):
            for i in range(1, n):
                ans[i][j] += ans[i-1][j]
        return ans
        