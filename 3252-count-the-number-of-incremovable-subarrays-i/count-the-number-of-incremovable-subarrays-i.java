class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int result = 0;
        // find the strictly increasing sequence from left
        boolean[] left_increasing = new boolean[n];
        int num = nums[0];
        int index = 0;
        left_increasing[0] = true;
        while (index + 1 < n && nums[index + 1] > num) {
            left_increasing[index+1] = true;
            num = nums[index + 1];
            index++;
        }
        // find the strictly decresing sequence from right to left
        boolean[] right_increasing = new boolean[n];
        num = nums[n-1];
        right_increasing[n-1] = true;
        index = n - 1;
        while (index > 0 && nums[index - 1] < num) {
            right_increasing[index - 1] = true;
            num = nums[index - 1];
            index--;
        }
        for (int len = 1; len <= n; len++) {
            for (int i=0; i <= n - len; i++) {
                int end = i + len - 1;
                boolean is_left_part_increasing = false;
                if (i==0 || left_increasing[i-1]) {
                    is_left_part_increasing = true;
                }
                boolean is_right_part_increasing = false;
                if (end == n - 1 || right_increasing[end + 1]) {
                    is_right_part_increasing = true;
                }
                if (is_left_part_increasing && is_right_part_increasing) {
                    // check if right most value on the left part is greater than left most value 
                    // on the right part
                    if (i == 0 || end == n-1) {
                        result++;
                    } else {                        
                        // check the right most value and left most value on left and right sides
                        if (nums[i-1] < nums[end + 1]) result++;
                    }
                }
            }
        }
        return result;
    }
}