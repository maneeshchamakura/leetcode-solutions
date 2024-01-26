class Solution {
    public static int mod = 1_000_000_000 + 7;
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n+1][m+1][k+1];
        for(int[][] mat_2d: dp) {
            for(int[] sub_arr: mat_2d) {
                Arrays.fill(sub_arr, -1);
            }
        }
        return solve(n, m, k, 0, 0, 0, dp);
    }

    public int solve(int n, int m, int k, int index, int currMax, int currCost, int[][][] dp) {
        // base case
        if (index == n) {
            // handle the last case
            if (currCost == k) return 1;
            return 0;
        }
        // write the memoization part here
        if (dp[index][currMax][currCost] != -1)
            return dp[index][currMax][currCost];
        // iterate through the nums and make
        // check whether this num contributes to change in max value
        int ans = 0;
        for(int num = 1; num <= m; num++) {
            int newMax = currMax;
            int newCost = currCost;
            if (num > newMax) {
                newMax = num;
                newCost++;
            }
            if (newCost > k) break;
            ans = (ans%mod + solve(n, m, k, index + 1, newMax, newCost, dp)%mod)%mod;
        }
        return dp[index][currMax][currCost] = ans;
    }
}