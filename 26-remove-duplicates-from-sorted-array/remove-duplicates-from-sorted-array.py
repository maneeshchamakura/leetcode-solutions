class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        index = -1
        prev = None
        for i in range(len(nums)):
            if index == -1 or prev != nums[i]:
                index += 1
                prev = nums[i]
                nums[index] = nums[i]
        return index + 1