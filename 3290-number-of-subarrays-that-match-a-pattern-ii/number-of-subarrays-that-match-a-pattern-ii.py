class Solution:
    def countMatchingSubarrays(self, nums: List[int], pattern: List[int]) -> int:
        n = len(nums)
        m = len(pattern)
        new_pattern = ""
        for val in pattern:
            if val == 1:
                new_pattern += "1"
            elif val == 0:
                new_pattern += "2"
            else:
                new_pattern += "3"
        text = ""
        for i in range(n-1):
            if nums[i] > nums[i+1]:
                text += "3"
            elif nums[i] == nums[i+1]:
                text += "2"
            else:
                text += "1"
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
        return count_substring(text, new_pattern)