class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        freq = Counter()
        for x in nums:
            # find the prime factors of num
            for p in range(2, isqrt(x) + 1):                   
                while x % p == 0:
                    x //= p
                    freq[p] += 1
            if x > 1:
                freq[x] += 1
        prefix = Counter()
        overlap = 0
        for i, num in enumerate(nums):
            if i <= len(nums) - 2:
                # current is num
                for p in range(2, isqrt(num) + 1):
                    if num % p == 0:
                        if prefix[p] == 0:
                            overlap += 1
                        while num % p == 0:
                            num //= p
                            prefix[p] += 1
                        if prefix[p] == freq[p]:
                            overlap -= 1
                if num > 1:
                    if prefix[num] == 0:
                        overlap += 1
                    prefix[num] += 1
                    if prefix[num] == freq[num]:
                        overlap -= 1
                if not overlap:
                    return i
        return -1