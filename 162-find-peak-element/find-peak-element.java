class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low=0, high=nums.length-1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (mid > 0 && nums[mid-1] > nums[mid]) {
                high = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid+1] > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}