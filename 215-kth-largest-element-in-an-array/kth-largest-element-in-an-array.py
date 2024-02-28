class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # use quick select here
        min_heap = nums[:k]
        heapify(min_heap)
        for i in range(k, len(nums)):
            if nums[i] > min_heap[0]:
                heappushpop(min_heap, nums[i])
        return min_heap[0]