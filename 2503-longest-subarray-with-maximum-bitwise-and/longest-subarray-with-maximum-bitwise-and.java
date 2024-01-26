class Solution {
    public int longestSubarray(int[] nums) {
        int max = Collections.max(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int len = 1;
        int index = 0;
        int n = nums.length;
        while (index < n) {
            if (nums[index] != max) {
                index++;
                continue;
            }
            // find the subarray from index with same values as max
            int start = index;
            while (index + 1 < n && nums[index+1] == max) index++;
            // start to index including
            len = Math.max(len, index - start + 1);
            // update index
            index++;
        }
        return len;
    }
}