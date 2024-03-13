class Solution:
    def pivotInteger(self, n: int) -> int:
        total_sum = (n*(n+1))//2
        sqrt_val = floor(sqrt(total_sum))
        if sqrt_val*sqrt_val == total_sum:
            return sqrt_val
        return -1
        