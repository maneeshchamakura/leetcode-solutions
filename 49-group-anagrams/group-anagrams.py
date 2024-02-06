class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = defaultdict(list)
        index = 0
        for string in strs:
            s = ''.join(sorted(string))
            ans[s].append(index)
            index += 1
        result = []
        for key, indices in ans.items():
            x = [strs[index] for index in indices]
            result.append(x)
        return result