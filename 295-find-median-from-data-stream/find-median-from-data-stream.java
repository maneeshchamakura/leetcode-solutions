class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
        return Integer.compare(b, a);
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {
        // do nothing for now
        maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int len1 = maxHeap.size();
        int len2 = minHeap.size();
        if ((len1 + len2) % 2 == 0) {
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2;
        } else {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */