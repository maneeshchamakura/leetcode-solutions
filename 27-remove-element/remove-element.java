class Solution {
    public static void swap(int[] arr, int i, int j) {
    arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
}
    public int removeElement(int[] nums, int val) {
        int pick = val;
        int n = nums.length;
        int i=0, j=n-1;
        if (n == 1) {
            if (nums[0] == val) return 0;
            return 1;
        }
        while (i < j) {
            if (nums[i] == pick) {
                if (nums[j] == pick) {
                    j--;
                } else {
                    swap(nums, i, j);
                    j--;
                    i++;
                }
            } else {
                if (nums[j] == pick) {
                    j--;
                    i++;
                } else {
                    i++;
                }
            }
        }
        int count = 0;
        for(int k=0;  k<n; k++) {
            if (nums[k] == pick) count++;
        }
        return n - count;
    }
}