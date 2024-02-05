class Solution:
    def firstUniqChar(self, s: str) -> int:
        s_counter = Counter(s)
        for i in range(len(s)):
            c = s[i]
            if s_counter[c] == 1:
                return i
        return -1