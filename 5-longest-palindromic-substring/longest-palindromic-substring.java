class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start=0, maxLen=1;
        for (boolean[] subarr: dp) {
            Arrays.fill(subarr, false);
        }
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
            if (i+1 != n) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    start = i;
                    maxLen = 2;
                    dp[i][i+1] = true;
                }
            }
        }
        for (int k=3; k <= n; k++) {
            for (int i=0; i <= n-k; i++) {
                int end = i + k - 1;
                if (s.charAt(i) == s.charAt(end) && dp[i+1][end-1]) {
                    dp[i][end] = true;
                    if (maxLen < k) {
                        maxLen = k;
                        start = i;
                    }
                } else {
                    dp[i][end]= false;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
    
    public int expandAroundIndex(String s, int i, int j) {
        while (i <= j && i >= 0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}