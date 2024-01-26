class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stack = []
        ans = 0
        n = len(arr)
        mod= 1000000000 + 7
        for i in range(n + 1):
            while stack and (i == n or arr[stack[-1]] >= arr[i]):
                mid = stack.pop()
                leftBoundary = stack[-1] if stack else -1
                rightBoundary = i
                prod = (mid - leftBoundary) * (rightBoundary - mid)
                ans += (prod * arr[mid]) %mod
                ans %= mod
            stack.append(i)
        return int(ans)