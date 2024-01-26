class Solution {
    public boolean search(int[] nums, int target) {
        int low=0, high=nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return true;
            }
            // if left is sorted or right is unsorted
            if (nums[low] < nums[mid] || nums[mid] > nums[high]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid +1;
                } else {
                    high =mid -1;
                }
            } else {
                high--;
            }
        }
        return false;
    }
}