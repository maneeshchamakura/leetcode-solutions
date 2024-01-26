class Solution:

    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        delta = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        @cache
        def dfs(i, j, moves):
            if i < 0 or i >= m or j < 0 or j >= n:
                return 1
            if moves == 0:
                return 0
            ans = 0
            for a, b in delta:
                ans = (ans + dfs(i + a, j + b, moves-1))%(10**9 + 7)
            return ans
        return dfs(startRow, startColumn, maxMove)