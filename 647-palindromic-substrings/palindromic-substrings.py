class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        dp = [[False]*n for _ in range(n)]
        # set one length to true
        for i in range(n):
            dp[i][i] = True
        # set two length to two
        for i in range(n-1):
            dp[i][i+1] = s[i] == s[i+1]
        for length in range(3, n+1):
            for i in range(0, n - length + 1):
                start = i
                end = i + length - 1
                if s[start] == s[end]:
                    dp[start][end] = dp[start + 1][end - 1]
        count = 0
        for sub_arr in dp:
            for is_valid in sub_arr:
                if is_valid:
                    count += 1
        return count