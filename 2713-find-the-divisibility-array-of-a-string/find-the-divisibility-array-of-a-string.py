class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        ans = []
        prefix = 0 
        for i, x in enumerate(word): 
            prefix = 10*prefix + ord(x) - 48
            prefix %= m 
            if prefix == 0: ans.append(1)
            else: ans.append(0)
        return ans 
            