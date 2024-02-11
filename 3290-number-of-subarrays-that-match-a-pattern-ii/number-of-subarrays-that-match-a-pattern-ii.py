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
        pattern = ''.join([str(i) for i in new_pattern])
        text = ''.join([str(i) for i in whole_arr])
        def compute_lps(string):
            lps = [0]*len(string)
            i = 0
            for j in range(1, len(string)):
                while i > 0 and string[j] != string[i]:
                    i = lps[i-1]
                if string[j] == string[i]:
                    i += 1
                lps[j] = i
            return lps
        def count_substring(string, substring):
            lps = compute_lps(substring)
            i = 0
            count = 0
            for j in range(len(string)):
                while i > 0 and string[j] != substring[i]:
                    i = lps[i-1]
                if string[j] == substring[i]:
                    i += 1
                if i == len(substring):
                    count += 1
                    i = lps[i-1]
            return count
        return count_substring(text, pattern)