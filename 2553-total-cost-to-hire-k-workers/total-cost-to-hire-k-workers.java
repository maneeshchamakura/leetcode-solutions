class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> left_min_heap = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
        });
        PriorityQueue<int[]> right_min_heap = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
        });
        int n = costs.length;
        // try inserting candiates elements to the left_min_heap
        int left_index = 0;
        while (left_index < candidates) {
            left_min_heap.add(new int[]{costs[left_index], left_index});
            left_index += 1;
        }
        left_index--;
        int right_index = n-1;
        while(right_index > left_index && right_index >= n - candidates) {
            right_min_heap.add(new int[]{costs[right_index], right_index});
            right_index--;
        }
        right_index++;
        int count = 0;
        long result = 0;
        while(!left_min_heap.isEmpty() && !right_min_heap.isEmpty() && count < k) {
            count++;
            if (left_min_heap.peek()[0] <= right_min_heap.peek()[0]) {
                // pick left_min_heap
                result += left_min_heap.poll()[0];
                if (left_index + 1 < right_index) {
                    left_min_heap.add(new int[]{costs[left_index + 1], left_index + 1});
                    left_index++;
                }
            } else {
                // pick right_min_heap
                result += right_min_heap.poll()[0];
                if (right_index - 1 > left_index) {
                    right_min_heap.add(new int[]{costs[right_index - 1], right_index - 1});
                    right_index--;
                }
            }
        }
        while(count < k) {
            count++;
            if (!left_min_heap.isEmpty()) {
                result += left_min_heap.poll()[0];
            } else {
                result += right_min_heap.poll()[0];
            }
        }
        return result;
    }
}