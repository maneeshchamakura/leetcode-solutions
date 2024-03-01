class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        n, m = len(text1), len(text2)
        dp = [list() for i in range(n + 1)]
        for i in range(n+1):
            for j in range(m+1):
                dp[i].append(0)
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                char1, char2 = text1[i-1], text2[j-1]
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                if char1 == char2:
                    dp[i][j] = max(dp[i][j], 1 + dp[i-1][j-1])
        return dp[n][m]