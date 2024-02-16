class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        count_dict = Counter(arr)
        values = sorted(count_dict.values())
        n = len(count_dict.keys())
        removed = 0
        for value in values:
            if k >= value:
                k -= value
                removed += 1
            else:
                break
        return n - removed