class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum=0;
        int start=0;
        int minLen =Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (nums[i] >= s) return 1;
            if (sum >= s) {
                while (start < i && sum >= s) {
                    minLen = Math.min(minLen, i - start+ 1);
                    sum -= nums[start];
                    start++;
                }
            }
        }
        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}