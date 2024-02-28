class MedianFinder:

    def __init__(self):
        self.max_heap = []
        self.min_heap = []
        heapify(self.min_heap)
        heapify(self.max_heap)

    def addNum(self, num: int) -> None:
        left_len = len(self.max_heap)
        right_len = len(self.min_heap)
        if left_len == 0:
            heappush(self.max_heap, -num)
            return
        # try putting the num on the min_heap
        if num < -self.max_heap[0]:
            heappush(self.max_heap, -num)
        else:
            heappush(self.min_heap, num)
        # rebalance the heaps
        if abs(len(self.max_heap) - len(self.min_heap)) >= 2:
            left_len = len(self.max_heap)
            right_len = len(self.min_heap)
            if left_len > right_len:
                heappush(self.min_heap, -heappop(self.max_heap))
            else:
                heappush(self.max_heap, -heappop(self.min_heap))      

    def findMedian(self) -> float:
        left_len = len(self.max_heap)
        right_len = len(self.min_heap)
        if (left_len + right_len)%2 == 0:
            return (-self.max_heap[0] + self.min_heap[0]) / 2
        if left_len > right_len:
            return -self.max_heap[0]
        return self.min_heap[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()