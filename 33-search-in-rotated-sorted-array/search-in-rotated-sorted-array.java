class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0] == target) ? 0: -1;
        int n = nums.length;
        if (nums[0] < nums[n-1]) {
            int index = Arrays.binarySearch(nums, target);
            if (index < 0) return -1;
            return index;
        }
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                // start to mid is increasing
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // mid to end is increasing
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return nums[start] == target ? start : -1;
    }
}