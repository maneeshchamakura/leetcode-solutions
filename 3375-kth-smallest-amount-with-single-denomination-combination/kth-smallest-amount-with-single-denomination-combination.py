class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        def func(k):
            ans = 0
            for i in range(1, len(coins)+1):
                for comb in combinations(coins, i):
                    ans -= k // lcm(*comb) *  pow(-1, i)
            return ans
        low, high = 0, min(coins)*k
        while low < high:
            mid = low + high >> 1
            if func(mid) < k:
                low = mid + 1
            else:
                high = mid
        return low