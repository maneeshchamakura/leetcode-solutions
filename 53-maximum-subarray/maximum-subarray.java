class Solution {
    public int maxSubArray(int[] nums) {
        return maxSum(nums, 0, nums.length - 1);
    }
    public int maxSum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left)/2;
        int leftSum = maxSum(nums, left, mid);
        int rightSum = maxSum(nums, mid+1, right);
        int crossSum = crossSum(nums, left, right);
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    public int crossSum(int[] nums, int left, int right) {
        int mid = left + (right - left)/2;
        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for (int i=mid; i>=left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i=mid+1; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }
}