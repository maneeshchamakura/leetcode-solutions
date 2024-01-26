class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        # make the numbers negative
        repeating = -1
        for num in nums:
            index = abs(num) - 1
            if nums[index] < 0:
                repeating = index + 1
            else:
                nums[index] *= -1
        missing = -1
        for i in range(len(nums)):
            if nums[i] > 0:
                missing = i + 1
        return [repeating, missing]