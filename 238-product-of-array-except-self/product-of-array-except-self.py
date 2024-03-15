class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1]*n
        # left to right
        prev = nums[0]
        for i in range(1, n):
            result[i] *= prev
            prev *= nums[i]
        # right to left
        prev = nums[n - 1]
        for i in reversed(range(n-1)):
            result[i] *= prev
            prev *= nums[i]
        return result