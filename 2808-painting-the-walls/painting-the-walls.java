class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] memo = new int[n][n+1];
        return dp(0, n, cost, time, memo);
    }
    public int dp(int i, int rem, int[] cost, int[] time, int[][] memo) {
        if (rem <= 0) return 0;
        if (i >= cost.length) return (int)1e9;
        if (memo[i][rem] != 0) return memo[i][rem];
        // paint
        int paint = cost[i] + dp(i+1, rem - 1 - time[i], cost, time, memo);
        // not paint
        int not_paint = dp(i+1, rem, cost, time, memo);
        memo[i][rem] = Math.min(paint, not_paint);
        return memo[i][rem];
    }
}