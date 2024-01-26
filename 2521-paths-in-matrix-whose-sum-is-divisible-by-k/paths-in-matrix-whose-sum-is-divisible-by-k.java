class Solution {
    public static int mod = 1_000_000_007;
    public int numberOfPaths(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;        
        int[][][] dp = new int[rows][cols][k];
        for(int[][] twod: dp) {
            for (int[] subarr: twod) {
                Arrays.fill(subarr, -1);
            }
        }
        return dfs(grid, dp, 0, 0, 0, k);
    }
    
    public int dfs(int[][] grid, int[][][] dp, int sum, int i, int j, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) return 0;
        sum += grid[i][j];  
        if (i == rows - 1 && j == cols - 1) {
            return (sum%k) == 0 ? 1: 0;
        }
        if (dp[i][j][sum%k] != -1) return dp[i][j][sum%k];              
        dp[i][j][sum%k] = (dfs(grid, dp, sum, i+1, j, k) + dfs(grid, dp, sum, i, j+1, k))%mod;
        return dp[i][j][sum%k];
    }
}