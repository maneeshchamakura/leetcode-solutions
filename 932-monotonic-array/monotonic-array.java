class Solution {
    public boolean isMonotonic(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) return true;
        // check montonically increasing
        int left = nums[0];
        int n = nums.length;
        boolean is_increasing=true;
        for(int i=1; i<n; i++) {
            if (left <= nums[i]) {
                left = nums[i];
            } else {
                is_increasing = false;
                break;
            }
        }
        if(is_increasing) return true;
        left = nums[0];
        boolean is_decreasing = true;
        for(int i=1; i<n; i++) {
            if (left >= nums[i]) {
                left = nums[i];
            } else {
                is_decreasing = false;
                break;
            }
        }
        return is_decreasing;
    }
}