class Solution {
    public int[] countBits(int n) {
        // use dp to find the answer
        if (n == 0) {
            return new int[]{0};
        } else if (n == 1) {
            return new int[]{0, 1};
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int prevPower = 1;
        int current = 2;
        while (current <= n) {
            if (current == prevPower*2) {
                dp[current] = 1;
                prevPower *= 2;
            } else {
                dp[current] = 1 + dp[current-prevPower];
            }
            current++;
        }
        return dp;
    }
}