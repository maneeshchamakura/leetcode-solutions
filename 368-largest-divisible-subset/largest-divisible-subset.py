class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        n = len(nums)
        dp = [1]*n
        nums.sort()
        max_size = 1
        index = 0
        for i in range(1, n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    dp[i] = max(dp[i], 1 + dp[j])
                    if dp[i] > max_size:
                        max_size = dp[i]
                        index = i
        # print (max_size, index)
        # print (dp)
        # construct result here
        result = []
        num = nums[index]
        for i in range(index, -1, -1):
            if num % nums[i] == 0 and dp[i] == max_size:
                result.append(nums[i])
                num = nums[i]
                max_size -= 1
        return result