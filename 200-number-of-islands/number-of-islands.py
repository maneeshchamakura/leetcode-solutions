class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        def markIslands(i, j):
            if i < 0 or i >= rows or j < 0 or j >= cols:
                return
            if grid[i][j] == "1":
                grid[i][j] = "0"
                markIslands(i, j+1)
                markIslands(i+1, j)
                markIslands(i, j-1)
                markIslands(i-1, j)
        islands = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    markIslands(i, j)
                    islands += 1
        return islands
