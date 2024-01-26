class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // find the first index from right side where arr[i] > arr[i-1]
        int n = nums.length;
        int index = -1;
        for (int i=n-1; i> 0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n-1);
            return;            
        }
        // find the first value from the right side that is greater than arr[i-1]
        int index2=-1;
        for (int i=n-1; i > index; i--) {
            if (nums[i] > nums[index]) {
                index2 = i;
                break;
            }
        }
        swap(nums, index, index2);
        reverse(nums, index+1, n-1);        
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;            
            j--;
        }
    }
}