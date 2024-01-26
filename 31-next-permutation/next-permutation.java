class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i, j;
        for(i=n-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i == -1) {
            reverse(nums, 0, n-1);
            return;
        }
        for (j=n-1; j > i; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums, j, i);
        reverse(nums, i+1, n-1);
    }
    public void reverse(int[] arr, int i, int j) {
        int start =i, end=j;
        while (start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}