class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # replace zero with -1
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                nums[i] = -1
        # count the length of the longest subarray where 
        # the sum is 0
        prefix_sum = [0]
        prefix_sum_dict = {0:-1}
        sum_so_far = 0
        result = 0
        for i in range(n):
            sum_so_far += nums[i]
            if sum_so_far not in prefix_sum_dict:
                prefix_sum_dict[sum_so_far] = i
            else:
                # it means
                # you have found a possible answer
                prev_index = prefix_sum_dict[sum_so_far]
                length = i - prev_index
                result = max(result, length)
            prefix_sum.append(sum_so_far)
        return result
        