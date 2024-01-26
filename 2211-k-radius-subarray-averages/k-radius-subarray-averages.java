class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;
        int n = nums.length;
        long sum = 0L;
        long[] prefix_sum = new long[n];
        for(int i=0; i<n; i++) {
            sum += nums[i];
            prefix_sum[i] = sum;
        }
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i=0; i<n; i++) {
            int left_most = i - k;
            int right_most = i + k;
            if (left_most < 0) continue;
            if (right_most >= n) continue;
            sum = left_most == 0 ? prefix_sum[i] : prefix_sum[i] - prefix_sum[left_most-1];
            sum += prefix_sum[right_most] - prefix_sum[i];
            sum /= (2*k + 1);
            result[i] = (int)sum;
        }
        return result;
    }
}