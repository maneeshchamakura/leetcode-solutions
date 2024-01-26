class Solution {
    public int minFallingPathSum(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        result.add(Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        Map<String, Integer> memo = new HashMap<>();
        for(int i=0; i<matrix.length; i++)
            min = Math.min(min, dfs(matrix, 0, i, matrix.length, memo));
        return min;
    }
    
    public int dfs(int[][] matrix, int row, int col, int n, Map<String, Integer> memo) {
        String key = row+"," + col;
        if (memo.containsKey(key)) return memo.get(key);
        // choose one
        if (row == n - 1) {
            return matrix[row][col];
        }
        int current = matrix[row][col];
        int[][] delta = {{1, 0}, {1, 1}, {1, -1}};
        int min = Integer.MAX_VALUE;
        for(int[] d: delta) {
            int new_row = row + d[0];
            int new_col = col + d[1];
            if (new_row >= 0 && new_row < n && new_col >=0 && new_col <n)
                min = Math.min(min, dfs(matrix, new_row, new_col, n, memo));
        }
        memo.put(key, min+ current);
        return min + current;
    }
    
}