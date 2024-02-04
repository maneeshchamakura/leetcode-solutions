
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_counter = Counter(t)
        s_counter = Counter()
        i = 0
        j = -1
        matches = 0
        ans = ""
        chars = len(t_counter.keys())
        while j < len(s):
            # starting from i and j
            if matches < chars:
                j += 1
                if j == len(s):
                    return ans
                s_counter[s[j]] += 1                
                if t_counter[s[j]] > 0 and t_counter[s[j]] == s_counter[s[j]]:
                    matches += 1
            else:
                s_counter[s[i]] -= 1                
                if t_counter[s[i]] > 0 and t_counter[s[i]] - 1 == s_counter[s[i]]:
                    matches -= 1
                i += 1
            if matches == chars:
                if not ans:
                    ans = s[i:j+1]
                elif (j - i + 1) < len(ans):
                    ans = s[i:j+1]
        return ans