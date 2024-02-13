class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        def compute_lps(string):
            n = len(string)
            lps = [0]*n
            i = 0
            for j in range(1, n):
                while i > 0 and string[i] != string[j]:
                    i = lps[i-1]
                if string[i] == string[j]:
                    i += 1
                lps[j] = i
            return lps
        def find_pattern(text, pattern):
            n = len(text)
            lps = compute_lps(pattern)
            i = 0
            for j in range(n):
                while i > 0 and pattern[i] != text[j]:
                    i = lps[i-1]
                if pattern[i] == text[j]:
                    i += 1
                if i == len(pattern):
                    return j - len(pattern) + 1
            return -1
        return find_pattern(haystack, needle)