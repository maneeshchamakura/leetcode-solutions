class Solution:
    def solve(self, nums, k):
        result = 0
        start = 0
        prev_k_index = 0
        for i in range(len(nums)):
            num = nums[i]
            if num == k:
                prev_k_index = i
                result += (prev_k_index - start + 1)
            elif num < k:
                if prev_k_index != -1:
                    result += (prev_k_index - start + 1)
            else:
                start = i + 1
                prev_k_index = -1
        return result
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        index = 0
        result = 0
        start = 0
        result = [0]*len(nums)
        if (minK == maxK):
            return self.solve(nums, minK)
        while index < len(nums):
            start = index
            min_index = -1
            max_index = -1
            while index < len(nums) and nums[index] >= minK and nums[index] <= maxK:
                if nums[index] == minK:
                    min_index = index
                    if max_index != -1:
                        result[index] = max_index - start + 1
                elif nums[index] == maxK:
                    max_index = index
                    if min_index != -1:
                        result[index] = min_index - start + 1
                else:
                    if max_index != -1 and min_index != -1:
                        result[index] = result[index-1]
                index += 1
            if start == index:
                index += 1
        print (result)
        return sum(result)
