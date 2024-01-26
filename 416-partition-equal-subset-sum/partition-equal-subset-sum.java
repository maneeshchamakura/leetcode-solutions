class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num: nums) sum += num;
        if ((sum & 1) == 1) return false;
        int n = nums.length;
        sum /=2;
        boolean[][] dp = new boolean[n+1][sum + 1];
        dp[0][0] = true;
        for (int i=1; i<=n; i++) {
            dp[i][0] = true;
        }
        for (int j=1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // rows is elements
        // columns is the possible subset sums
        // check whether you can pick it or not pick it
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}