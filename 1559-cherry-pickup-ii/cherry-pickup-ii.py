class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        def dfs(row, col1, col2, rows, cols, memo):
            if col1 < 0 or col1 >= cols or col2 < 0 or col2 >= cols:
                return 0
            if row == rows - 1 and col1 != col2:
                return grid[row][col1] + grid[row][col2]
            if (row, col1, col2) in memo:
                return memo[(row, col1, col2)]
            # for every possible robot1 position 
            # choose every possible robot2 position
            dy = [-1, 0, 1]
            max_so_far = 0
            for y_delta in dy:
                robot1_x = row + 1
                robot1_y = y_delta + col1
                for y_delta in dy:
                    robot2_x = row + 1
                    robot2_y = y_delta + col2
                    if robot1_y != robot2_y:
                        max_so_far = max(max_so_far, dfs(robot1_x, robot1_y, robot2_y, rows, cols, memo))
            local_ans = max_so_far + grid[row][col1] + grid[row][col2]
            memo[(row, col1, col2)] = local_ans
            return local_ans
        return dfs(0, 0, len(grid[0]) - 1, len(grid), len(grid[0]), {})
