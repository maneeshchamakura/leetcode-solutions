class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        long result = 0L;
        int i=0;
        int n = nums.length;
        for(i=0; i+1<n; i++) {
            if (nums[i] < nums[i+1]) {
                continue;
            }
            break;
        }
        if (i == n - 1) {
            result += n*1L;
            result *= (n + 1);
            result /= 2;
            return result;
        }
        result += (i + 2);
        for (int j=n-1; j >= 0; j--) {
            if(j!= n- 1 && nums[j] >= nums[j+1]) break;
            while (i >= 0 && nums[i] >= nums[j]) i--;
            result += (i + 2);
        }
        return result;
    }
}