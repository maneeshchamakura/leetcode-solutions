class Solution {
    public int longestPalindromeSubseq(String s) {
        return lcs(s, new StringBuffer(s).reverse().toString());
    }

    public int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] memo = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            for (int j=1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    memo[i][j] = 1 + memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
                }
            }
        }
        return memo[n][m];
    }
}