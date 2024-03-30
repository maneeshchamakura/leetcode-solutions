class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        def convert(count):
            value = 0
            for i in range(32):
                if count[i] > 0:
                    value += 2**i
            return value
        start, res = 0, len(nums) + 1
        count = [0]*32
        for end, num in enumerate(nums):
            # add the current num to the count
            for i in range(32):
                if num & (1 << i):
                    count[i] += 1
            while start <= end and convert(count) >= k:
                for i in range(32):
                    if nums[start] & (1 << i):
                        count[i] -= 1
                res = min(res, end - start + 1)
                start += 1
        return res if res <= len(nums) else -1
