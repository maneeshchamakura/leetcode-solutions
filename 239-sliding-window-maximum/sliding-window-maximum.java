class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            // remove the invalid indices
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // remove the indices that won't contribute to max
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            // add the current index
            deque.offerLast(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}