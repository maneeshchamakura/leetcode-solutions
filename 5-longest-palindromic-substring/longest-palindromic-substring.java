class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        String result = s.charAt(0)+"";
        // int max = 1L;
        // mark the 2 length paldinromes
        for (int i=0; i<n-1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (dp[i][i+1]) {
                result = s.substring(i, i+2);
            }
        }        
        for (int len = 3; len <= n; len++) {
            for (int i=0; i <= n - len; i++) {
                int end = i + len - 1;
                if (s.charAt(i) == s.charAt(end)) {
                    if (dp[i+1][end-1]) {
                        if (end - i + 1 > result.length()) {
                            result = s.substring(i, end+1);
                        }
                        dp[i][end] = true;
                    }
                }
            }
        }
        return result;
    }
}