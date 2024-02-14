class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0]*n
        positive_i = 0
        negative_i = 1
        for num in nums:
            if num > 0:
                result[positive_i] = num
                positive_i += 2
            else:
                result[negative_i] = num
                negative_i += 2
        return result
