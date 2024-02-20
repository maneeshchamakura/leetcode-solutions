class Solution:
    def missingNumber(self, nums: List[int]) -> int:
       return reduce(lambda x, y: x ^ y, nums + list(range(len(nums) + 1)))