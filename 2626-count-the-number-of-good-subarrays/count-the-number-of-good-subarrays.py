class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        good_subarrays = 0
        n = len(nums)
        count = Counter()
        j = 0
        window_pairs = 0
        for i in range(n):
            # expand the window
            while j < n and window_pairs < k:
                count[nums[j]] += 1
                window_pairs += (count[nums[j]] - 1)
                j += 1
            if window_pairs >= k:
                good_subarrays += (n - j + 1)
            else:
                break
            # collapse the window
            count[nums[i]] -= 1
            window_pairs -= count[nums[i]]
        return good_subarrays