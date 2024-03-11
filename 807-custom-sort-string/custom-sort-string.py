class Solution:
    def customSortString(self, order: str, s: str) -> str:
        pos = {}
        for i in range(len(order)):
            pos[order[i]] = i+1
        print (pos)
        chars = list(s)
        chars.sort(key=lambda x: pos.get(x, 100))
        return ''.join(chars)