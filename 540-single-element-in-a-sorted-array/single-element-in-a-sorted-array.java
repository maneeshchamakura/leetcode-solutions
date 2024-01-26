class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n  = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            } else if (nums[mid] == nums[mid-1]) {
                if ((mid + 1) % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                if ((n - mid) % 2 == 0) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
        }
        return nums[start];
    }
}