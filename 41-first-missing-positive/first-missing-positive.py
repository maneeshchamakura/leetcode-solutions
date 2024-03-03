class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # check if one is the answer
        is_one_ans = True
        n = len(nums)
        for i in range(n):
            if nums[i] == 1:
                is_one_ans = False
            elif nums[i] < 0:
                nums[i] = 0
            elif nums[i] > n:
                nums[i] = 0
        if is_one_ans:
            return 1
        # make the negative values and values greater than 
        for i in range(n):
            if nums[i] == 0:
                continue
            elif nums[i] == -1:
                continue
            else:
                index = abs(nums[i]) - 1
                if nums[index] == 0:
                    nums[index] = -1
                elif nums[index] > 0:
                    nums[index] *= -1
        for i in range(1, n):
            if nums[i] >= 0:
                return i + 1
        return n + 1