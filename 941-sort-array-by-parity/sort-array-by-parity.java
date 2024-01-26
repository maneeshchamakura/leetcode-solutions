class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) return nums;
        int len = nums.length;
        int index = 0;
        for (int i=0; i<len; i++) {
            int current_num = nums[i];
            if (current_num % 2 == 0) {
                // even
                // swap nums[index] and nums[i]
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            } 
        }
        return nums;
    }
}