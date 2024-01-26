class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if (leftSize == 0) {
            maxHeap.add(num);
            return;
        }
        if (num > maxHeap.peek()) minHeap.add(num);
        else maxHeap.add(num);
        leftSize = maxHeap.size();
        rightSize = minHeap.size();
        if (Math.abs(leftSize - rightSize) > 1) {
            if (leftSize > rightSize) {
                minHeap.add(maxHeap.remove());
            } else {
                maxHeap.add(minHeap.remove());
            }
        }
    }
    
    public double findMedian() {
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if ((leftSize + rightSize) % 2 == 0) {
            double res = minHeap.peek();
            res += maxHeap.peek();
            return res/2;
        } else {
            if (leftSize > rightSize) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */