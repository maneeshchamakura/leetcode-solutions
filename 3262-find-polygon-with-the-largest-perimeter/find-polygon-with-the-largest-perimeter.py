class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        # sort the nums
        nums.sort()
        # find the prefix sum
        prefix_sum = [0]*len(nums)
        sum_so_far = 0
        for i in range(len(nums)):
            sum_so_far += nums[i]
            prefix_sum[i] = sum_so_far
        max_val = -1
        for i in range(2, len(nums)):
            current_elem = nums[i]
            left_sum = prefix_sum[i] - current_elem
            if left_sum > current_elem:
                max_val =  prefix_sum[i]
        return max_val