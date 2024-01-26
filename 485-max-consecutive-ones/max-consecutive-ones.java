class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int index = 0;
        int max = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
            index++;
        }
        return max;
    }
}