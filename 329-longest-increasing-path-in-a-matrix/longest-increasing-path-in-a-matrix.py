class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        rows, cols = len(matrix), len(matrix[0])
        dp = [[0]*cols for i in range(rows)]
        def dfs(r, c):
            if not dp[r][c]:
                value = matrix[r][c]
                res = 1 + max(
                dfs(r-1, c) if r and matrix[r-1][c] > value else 0,
                dfs(r+1, c) if r < rows - 1 and matrix[r+1][c] > value else 0,
                dfs(r, c-1) if c and matrix[r][c-1] > value else 0,
                dfs(r, c+1) if c < cols - 1 and matrix[r][c+1] > value else 0
                )
                dp[r][c] = res
                return res
            return dp[r][c]
        # result = [[0]*cols for i in range(rows)]
        max_len = 1
        for row in range(rows):
            for col in range(cols):
                max_len = max(max_len, dfs(row, col))
        return max_len