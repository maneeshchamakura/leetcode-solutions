class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        for (int i=1; i<nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            globalMax = Math.max(globalMax, nums[i]);
        }
        return globalMax;
    }
}