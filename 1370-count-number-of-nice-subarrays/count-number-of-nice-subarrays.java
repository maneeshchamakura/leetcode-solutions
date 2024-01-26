class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0) return count;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int oddCount = 0;int x = 0; 
        for (int num: nums) {
            if (num % 2 == 1) x++;
        }
        if (x == 0)return 0; 
        while(end < n) {
            if (nums[end] % 2 == 0) {
                end++;
            } else {
                oddCount++;
                if (oddCount == k) {
                    int temp = end;
                    end++;
                    // expand as much as you can from here till you reach any odd number
                    while (end < n && nums[end] % 2 == 0) {
                        end++;
                    }
                    end--;
                    int len = end - temp + 1;
                    while (start < n && nums[start] % 2 == 0) {
                        count += len;
                        start++;
                    }
                    start++;
                    count += len;
                    oddCount--;
                    end++;
                } else 
                end++;
            }
        }
        return count;
    }
}