class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        if (nums[0] < nums[n-1]) {
            int index = Arrays.binarySearch(nums, 0, n, target);
            if (index < 0) return -1;
            return index;
        }
        int low=0, high=n-1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return nums[low] == target ? low: -1;
    }
}