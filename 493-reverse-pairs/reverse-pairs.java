class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    public int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = start + (end - start)/2;
            int val1 = mergeSort(nums, start, mid);
            int val2 = mergeSort(nums, mid+1, end);            
            return merge(nums, start, mid, end) + val1 + val2;
            
        }
        return count;
    }
    public int  merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start, p2= mid+1;
        int index =0;
        int i=start, j=mid+1;
        int count = 0;
        while(i <= mid && j<= end) {
            if (nums[i] > 2L*nums[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }
        while (p1 <= mid && p2 <= end) {
            if (nums[p1] < nums[p2]) {
                temp[index++] = nums[p1++];
            } else {
                temp[index++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[index++] = nums[p1++];
        }
        while (p2 <= end) {
            temp[index++] = nums[p2++];
        }
        for (i=0; i<temp.length; i++) {
            nums[start + i] = temp[i];
        }
        return count;
    }
}