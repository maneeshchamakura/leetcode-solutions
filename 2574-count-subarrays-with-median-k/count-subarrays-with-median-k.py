class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        idx = nums.index(k)
        freq = Counter()
        prefix = 0
        for i in reversed(range(idx + 1)):
            prefix += int(nums[i] > k) - int(nums[i] < k)
            freq[prefix] += 1
        ans = prefix = 0
        for i in range(idx, len(nums)):
            prefix += int(nums[i] > k) - int(nums[i] < k)
            ans += freq[-prefix] + freq[-prefix + 1]
        return ans