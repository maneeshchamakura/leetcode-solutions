class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        # sort the array in-place
        nums.sort()
        res = []
        if len(nums) < 3:
            return res
        for i in range(0, len(nums), 3):
            if nums[i+2] - nums[i] <= k:
                res.append(nums[i:i+3])
            else:
                return []
        return res