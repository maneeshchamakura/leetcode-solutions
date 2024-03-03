class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        memo = {}
        def dfs(s1, s2):
            key = (s1, s2)
            if key in memo:
                return memo[key]
            # try matching s1 with s2
            if len(s2) == 0:
                memo[key] = len(s1)
                return len(s1)
            if len(s1) == 0:
                memo[key] = len(s2)
                return len(s2)
            # check if the first characters match
            if s1[0] == s2[0]:
                res = dfs(s1[1:], s2[1:])
                memo[key] = res
                return res
            # perform three operations
            ins_op = dfs(s1, s2[1:])
            del_op = dfs(s1[1:], s2)
            rep_op = dfs(s1[1:], s2[1:])
            res = min(ins_op, del_op, rep_op) + 1
            memo[key] = res
            return res
        return dfs(word1, word2)