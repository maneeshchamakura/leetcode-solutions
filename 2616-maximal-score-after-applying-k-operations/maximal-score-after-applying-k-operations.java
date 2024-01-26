class Solution {
    public long maxKelements(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0L;
        long score = 0;
        Arrays.sort(nums);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=nums.length - 1; i >= 0 && i >= nums.length - k; i--) {
            maxHeap.add(nums[i]);
        }
        while (k-- > 0) {
            int num = maxHeap.poll();
            score += num*1L;
            double val = num + 0.0;
            val /= 3;
            val = Math.ceil(val);
            maxHeap.add((int)val);
        }
        return score;
    }
}