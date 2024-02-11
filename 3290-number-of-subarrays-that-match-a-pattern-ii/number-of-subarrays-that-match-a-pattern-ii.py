class Solution:
    def countMatchingSubarrays(self, nums: List[int], pattern: List[int]) -> int:
        n = len(nums)
        m = len(pattern)
        count = 0
        new_pattern = []
        for val in pattern:
            if val == 1:
                new_pattern.append(1)
            elif val == 0:
                new_pattern.append(2)
            elif val == -1:
                new_pattern.append(3)
        whole_arr = []
        for i in range(n-1):
            if nums[i] > nums[i+1]:
                whole_arr.append(3)
            elif nums[i] == nums[i+1]:
                whole_arr.append(2)
            else:
                whole_arr.append(1)
        prime = 31
        first_hash = 0
        count = 0
        prod = 1
        pattern_hash = 0
        mod = 10**9 + 1
        for i in range(m):
            first_hash = ((first_hash*prime)%mod + whole_arr[i]%mod)%mod
            pattern_hash = ((pattern_hash*prime)%mod + new_pattern[i]%mod)%mod
            if not i == m - 1:
                prod = (prod%mod * prime%mod)%mod
        if first_hash == pattern_hash:
            count += 1
        for i in range(m, len(whole_arr)):
            first_hash = (first_hash%mod - (whole_arr[i-m]%mod * prod%mod)%mod)%mod
            first_hash = (first_hash%mod * prime%mod)%mod
            first_hash = (first_hash%mod + whole_arr[i]%mod)%mod
            if first_hash == pattern_hash:
                count += 1
        return count
