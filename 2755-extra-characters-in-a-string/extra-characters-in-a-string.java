class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        // bottom up approach
        int[] dp = new int[51];
        int n = s.length();
        for (int i=n-1; i>=0; i--) {
            dp[i] = 1 + dp[i+1];
            for(String word: dictionary){
                // check whether this word exists as substring starting from
                // the i-th index
                int cur_len = word.length();
                if (i+cur_len <= n && s.substring(i, i+cur_len).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i+cur_len]);
                } 
            }
        }
        return dp[0];
    }
}