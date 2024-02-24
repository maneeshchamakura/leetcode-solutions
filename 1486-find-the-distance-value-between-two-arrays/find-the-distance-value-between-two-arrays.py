class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        count = 0
        for num in arr1:
            # find num - d and num + d
            if bisect.bisect_left(arr2, num - d) == bisect.bisect_right(arr2, num + d):
                count += 1
        return count