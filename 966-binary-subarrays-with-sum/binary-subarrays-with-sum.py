class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        # 1 1 2 2 3 goal = 2
        nums_count = defaultdict(int)
        sum_so_far = 0
        result = 0
        for num in nums:
            sum_so_far += num
            if sum_so_far == goal:
                result += 1
            other_num = sum_so_far - goal
            if nums_count[other_num] > 0:
                result += nums_count[other_num]
            nums_count[sum_so_far] += 1
        return result