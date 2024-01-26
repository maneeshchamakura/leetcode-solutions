class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:        
        m = len(text2)
        n = len(text1)
        dp = [[0]*(m+1) for i in range(n + 1)]
        for i in range(1, m + 1):
            current_char = text2[i-1]
            for j in range(1, n + 1):
                # i belongs to text2
                # j belongs to text1
                current_char_2 = text1[j-1]
                if current_char == current_char_2:
                    dp[j][i] = 1 + dp[j-1][i-1]
                else:
                    dp[j][i] = max(dp[j][i], max(dp[j][i-1], dp[j-1][i]))
        return dp[n][m]