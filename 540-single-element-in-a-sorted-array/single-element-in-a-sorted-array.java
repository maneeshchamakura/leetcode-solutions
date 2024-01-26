class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, n=nums.length, end=n-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            int leftLen, rightLen;
            if (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) return nums[mid];
            if (nums[mid-1] == nums[mid]) {
                leftLen = mid - start + 1;
                rightLen = end - mid;
                if (leftLen % 2 == 1) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                rightLen = end - mid + 1;
                leftLen = mid - start;
                if (rightLen % 2 == 1) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }            
        }
        return nums[start];
    }
}