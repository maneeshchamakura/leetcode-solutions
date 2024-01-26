class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int index = find_first(nums, target, 0, nums.length-1);
        if (index == -1) return result;
        result[0] = index;
        result[1] = find_last(nums, target, 0, nums.length-1);
        return result;
    }

    public int find_first(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) {
            // last position
            if (nums[low] == target) return low;
            return -1;
        }
        int mid = low + (high - low)/2;
        if (nums[mid] == target) {
            // go to left as we need to look at left for possible occurences
            return find_first(nums, target, low, mid);
        } else if (nums[mid] < target) {
            return find_first(nums, target, mid + 1, high);
        } else {
            return find_first(nums, target, low, mid-1);
        }        
    }

    public int find_last(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) {
            // last position
            if (nums[low] == target) return low;
            return -1;
        }
        int mid = low + (high-low)/2;
        if (nums[mid] == target) {
            if (high - low == 1) {
                if (nums[high] == target) return high;
                return mid;
            }
            return find_last(nums, target, mid, high);
        } else if (nums[mid] < target) {
            return find_last(nums, target, mid + 1, high);
        } else {
            return find_last(nums, target, low, mid - 1);
        }
    }
}