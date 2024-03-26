class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        one_present = 0
        for i in range(n):
            if nums[i] == 1:
                one_present = 1
            elif nums[i] <= 0 or nums[i] > n:
                nums[i] = 1
        if one_present == 0:
            return 1
        for i in range(n):
            current = abs(nums[i])
            if current == 1:
                continue
            elif nums[current-1] < 0:
                continue
            else:
                nums[current-1] *= -1
        for i in range(1, n):
            if nums[i] > 0:
                return i + 1
        return n + 1