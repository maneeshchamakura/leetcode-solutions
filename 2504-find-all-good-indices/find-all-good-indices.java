class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        // min size is 2*k + 1
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n < 2*k + 1) return result;
        int bad1 = 0;
        int bad2 = 0;
        // non-increasing
        int prev = Integer.MAX_VALUE;
        for (int i=0; i<k; i++) {
            if(nums[i] > prev) {
                bad1 = i;
            }
            prev = nums[i];
        }
        prev = 0;
        // non-decreasing
        for (int i=k+1; i <= 2*k; i++) {
            if (nums[i] < prev) {
                bad2 = i - (k + 1);
            }
            prev = nums[i];
        }
        for (int i=k; i <= n - k - 1; i++) {
            if (bad1 == 0 && bad2 == 0) {
                result.add(i);
            }
            if (bad1 > 0) bad1--;
            if (bad2 > 0) bad2--;
            if(nums[i] > nums[i-1]) {
                bad1 = k - 1;
            }
            if (i + k + 1 < n && nums[i+k+1] < nums[i+k]) {
                bad2 = k - 1;
            }
        }
        return result;
    }
}