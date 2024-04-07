class Solution:
    def minOperationsToMakeMedianK(self, nums: List[int], k: int) -> int:
        n = len(nums)
        mid = n // 2
        nums.sort()
        # 2 5 5 6 8
        if nums[mid] == k:
            return 0
        elif nums[mid] > k:
            # decrease
            ops = nums[mid] - k
            nums[mid] = k
            for i in range(mid-1, -1, -1):
                if nums[i] > nums[i+1]:
                    ops += nums[i] - k
                    nums[i] = k
            return ops
        else:
            ops = k - nums[mid]
            nums[mid] = k
            for i in range(mid + 1, n):
                if nums[i] < nums[i-1]:
                    ops += k - nums[i]
                    nums[i] = k
            return ops