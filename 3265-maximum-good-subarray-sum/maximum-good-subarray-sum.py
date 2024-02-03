class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        indices = {}
        n = len(nums)
        prefix_sum = [0]*(n+1)
        temp_sum = 0
        found = False
        result = 0
        for i in range(n):
            temp_sum += nums[i]
            prefix_sum[i+1] = temp_sum
        for i in range(n):
            num = nums[i]
            target1 = num + k
            target2 = num - k
            if target1 in indices:
                if not found:
                    found = True
                    result = prefix_sum[i+1] - prefix_sum[indices[target1]]
                else:
                    result = max(result, prefix_sum[i+1] - prefix_sum[indices[target1]])
            if target2 in indices:
                if not found:
                    found = True
                    result = prefix_sum[i+1] - prefix_sum[indices[target2]]
                else:
                    result = max(result, prefix_sum[i+1] - prefix_sum[indices[target2]])
            if num not in indices or (prefix_sum[i] - prefix_sum[indices[num]]) <= 0:
                indices[num] = i


        return (result if found else 0)