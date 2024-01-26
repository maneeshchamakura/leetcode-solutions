class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{firstOccurence(nums, target), lastOccurence(nums, target)};
    }
    public int firstOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (nums[low] == target) ? low: -1;
    }
    public int lastOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if (mid == low) {
                    if (nums[mid] == nums[mid+1]) return mid+1;
                    return mid;
                } else {
                    low = mid;   
                }                
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            } 
        }
        return (nums[low] == target) ? low: -1;
    }
}