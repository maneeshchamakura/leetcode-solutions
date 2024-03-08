class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        x = Counter(nums)
        result = 0
        max_so_far = 0
        for key in x:
            if x[key] > max_so_far:
                max_so_far = x[key]
                result = x[key]
            elif x[key] == max_so_far:
                result += x[key]
        return result