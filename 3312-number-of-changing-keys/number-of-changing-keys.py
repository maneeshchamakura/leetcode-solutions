class Solution:
    def countKeyChanges(self, s: str) -> int:
        s = s.upper()
        count = 0
        index = 0
        while index < len(s):
            # see how many same characters are there on this character side
            c = s[index]
            while index < len(s) and c == s[index]:
                index += 1
            count += 1
        return count - 1
            