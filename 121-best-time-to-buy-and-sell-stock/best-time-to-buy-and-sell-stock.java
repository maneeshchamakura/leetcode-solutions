class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            suffix[i] = Math.max(suffix[i+1], nums[i]);
        }
        int max = 0;
        for (int i=n-2; i>=0; i--) {
            int diff = suffix[i+1] - nums[i];
            max = Math.max(diff, max);
        }
        return max;
    }
}