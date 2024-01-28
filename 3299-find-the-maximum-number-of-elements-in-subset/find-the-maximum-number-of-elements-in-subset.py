from collections import Counter
from math import floor, ceil
class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        nums.sort()
        count_dict = Counter(nums)
        visited = set()
        max_len = 1
        if 1 in count_dict:
            one_count = count_dict[1]
            if one_count % 2 == 1:
                max_len = max(max_len, one_count)
            else:
                max_len = max(max_len, one_count - 1)
        for i in range(len(nums) - 1, -1, -1):
            num = nums[i]
            if num == 1:
                continue
            current = num
            first_val = int(math.sqrt(current))
            length = 1
            while first_val in count_dict and first_val*first_val == current:
                if count_dict[first_val] >= 2:
                    length += 1
                else:
                    break
                current = first_val
                first_val = int(math.sqrt(current))
            max_len = max(max_len, 2*length - 1)
        return max_len
                
        