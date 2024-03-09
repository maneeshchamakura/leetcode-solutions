class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        first, len1 = 0, len(nums1)
        second, len2 = 0, len(nums2)
        while first < len1 and second < len2:
            if nums1[first] == nums2[second]:
                return nums1[first]
            if nums1[first] < nums2[second]:
                first += 1
            else:
                second += 1
        return -1