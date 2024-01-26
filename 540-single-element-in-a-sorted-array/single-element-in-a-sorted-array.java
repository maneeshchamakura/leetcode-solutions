class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0, high =nums.length-1;
        while (low < high) {
            int mid = (low + (high - low)/2);
            if (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) {
                return nums[mid];
            }
            if (nums[mid-1] == nums[mid]) {
                if((mid - low + 1)%2 == 1) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if ((high - mid + 1)% 2 == 1) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}