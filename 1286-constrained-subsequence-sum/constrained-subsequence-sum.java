class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        maxHeap.add(new int[]{nums[0], 0});
        int ans = nums[0];
        for (int i=1; i<nums.length; i++) {
            while((i - maxHeap.peek()[1]) > k) maxHeap.remove();
            int temp = Math.max(0, maxHeap.peek()[0]) + nums[i];
            ans = Math.max(ans, temp);
            maxHeap.add(new int[] {temp, i});
        }
        return ans;
    }
}