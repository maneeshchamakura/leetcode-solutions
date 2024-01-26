class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left =0, right=nums.length - 1;
        for (int i=0; i<=right;) {
            switch(nums[i]) {
                case 0:
                    swap(nums, i, left);left++;i++;break;
                case 1:
                    i++;break;
                case 2:
                    swap(nums, i, right); right--;
            }
        }
    }
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}