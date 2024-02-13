class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 1
        majority_elem = nums[0]
        for i in range(1, len(nums)):
            num = nums[i]
            if num == majority_elem:
                count += 1
            else:
                if count == 1:
                    count = 1
                    majority_elem = num
                else:
                    count -= 1
        return majority_elem