class Solution:
    def numTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        nums1_squares = [num*num for num in nums1]
        nums2_squares = [num*num for num in nums2]
        # print(nums1_squares, nums2_squares)
        # print (nums1, nums2)        
        count = 0
        n, m = len(nums1), len(nums2)
        # find type1
        for square in nums1_squares:
            nums2_dict = defaultdict(int)
            for j in reversed(range(m)):
                # for this j find k
                current_j = nums2[j]
                if square % current_j == 0:
                    # print ("here", square, current_j)
                    target_k = square // current_j
                    count_k = nums2_dict[target_k]
                    count += count_k
                nums2_dict[current_j] += 1
        # print (count, "here")        
        # find type2
        for square in nums2_squares:
            nums1_dict = defaultdict(int)
            for j in reversed(range(n)):
                # for this j find k
                current_j = nums1[j]
                if square % current_j == 0:
                    target_k = square // current_j
                    count_k = nums1_dict[target_k]
                    count += count_k
                nums1_dict[current_j] += 1
        return count

