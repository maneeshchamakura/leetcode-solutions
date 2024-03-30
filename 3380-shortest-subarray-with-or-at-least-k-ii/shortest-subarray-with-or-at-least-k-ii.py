class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        def f(count):
            res = 0
            for i, c in enumerate(count):
                if c > 0: res += 1 << i
            return res
        
        count = [0] * 32
        start, res = 0, len(nums) + 1
        for end, num in enumerate(nums):
            for i in range(32):
                if num & (1 << i):
                    count[i] += 1
            while start <= end and f(count) >= k:
                for i in range(32):
                    if nums[start] & (1 << i):
                        count[i] -= 1
                res = min(res, end - start + 1)
                start += 1

        return res if res <= len(nums) else -1