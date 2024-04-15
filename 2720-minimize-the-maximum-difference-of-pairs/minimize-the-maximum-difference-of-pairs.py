class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        nums.sort()
        n = len(nums)
        low, high = 0, nums[-1] - nums[0]
        while low < high:
            mid = (low + high) // 2
            pairs_count = 0
            i = 1
            while i < n:
                if nums[i] - nums[i-1] <= mid:
                    i += 1
                    pairs_count += 1
                i += 1
            if pairs_count >= p:
                high = mid
            else:
                low = mid + 1
        return low