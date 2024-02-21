class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            if nums[0] == 0:
                return 0
            return 1
        if nums[0] < 0 and nums[n-1] < 0:
            return n
        if nums[0] > 0 and nums[n-1] > 0:
            return n
        # floor of zero
        low, high = 0, n - 1
        while low < high:
            mid = low + (high - low) // 2
            if low == high - 1:
                if nums[mid+1] < 0:
                    low = mid + 1
                break
            if nums[mid] < 0:
                low = mid
            else:
                high = mid - 1
        negatives = 0 if nums[low] >= 0 else low + 1
        # ceil of zero
        low, high = 0, n - 1
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] <= 0:
                low = mid + 1
            else:
                high = mid
        positives = 0 if nums[low] <= 0 else n - low
        return max(positives, negatives)