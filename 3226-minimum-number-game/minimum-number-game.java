class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int num: nums) pqueue.offer(num);
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        while (!pqueue.isEmpty()) {
            int first = pqueue.poll();
            int second = pqueue.poll();
            result[index++] = second;
            result[index++] = first;
        }
        return result;
    }
}