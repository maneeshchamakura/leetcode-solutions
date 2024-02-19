class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n < 1:
            return False
        first = n
        second = n - 1
        res = first & second
        return res == 0