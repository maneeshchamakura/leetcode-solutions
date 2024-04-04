class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        prev_index = 0
        prev = None
        count = 0
        for i in range(len(nums)):
            if nums[i] != prev:                
                # swap current and prev_index
                nums[prev_index] = nums[i]
                prev_index += 1
                prev = nums[i]
                count = 1
            else:
                if count < 2:
                    count += 1
                    nums[prev_index] = nums[i]
                    prev_index += 1
        return prev_index
                    