class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        window = Counter()
        start = 0
        index = 0
        result = 1
        while index < len(nums):
            num = nums[index]
            # try adding to the window counter
            prev_count = window[num]
            if prev_count + 1 > k:
                # remove the left most one
                window[nums[start]] -= 1
                start += 1
            else:
                window[num] += 1
                result = max(result, index - start + 1)
                index += 1
        return result