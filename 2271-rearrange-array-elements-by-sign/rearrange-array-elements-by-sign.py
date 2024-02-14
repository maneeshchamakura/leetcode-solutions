class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0]*n
        positive_i = 0
        negative_i = 1
        for i in range(len(nums)):
            if nums[i] > 0:
                result[positive_i] = nums[i]
                positive_i += 2
            else:
                result[negative_i] = nums[i]
                negative_i += 2
        return result
