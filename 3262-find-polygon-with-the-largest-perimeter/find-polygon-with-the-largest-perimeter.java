class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] arr = new long[n];
        long sum = 0L;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
        long res= -1L;
        for(int i=2; i<n; i++) {
            if (arr[i-1] > nums[i]) {
                res = arr[i];
            }
        }
        return res;
    }
}