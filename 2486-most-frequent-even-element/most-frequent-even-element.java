class Solution {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int result = -1;
        int max_count = 0;
        int index = 0;
        while (index < nums.length) {
             int num = nums[index];
            int start = index;
            while(index + 1 < nums.length && nums[index+1] == num) {
                index++;
            }
            int count = index - start + 1;
            if (num % 2 == 0) {
                if (count > max_count) {
                    result = num;
                    max_count = count;
                }
            }
            index++;
        }
        return result;
    }
}