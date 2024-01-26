class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int start_pos = 0;
        int index = 0;
        while (index < nums.length) {
            int current = nums[index];
            // find duplicates for current;
            while (index < nums.length && nums[index] == current) {
                index++;
            }
            nums[start_pos++] = current;
        }
        return start_pos;
    }
}