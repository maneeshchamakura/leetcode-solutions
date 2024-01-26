class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-1; i++) {
            int num = nums[i];
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + num;
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(num, nums[start], nums[end])));
                    int start_val = nums[start];
                    // ignore the duplicate values
                    while (start < end && start_val == nums[start]) start++;
                    int end_val = nums[end];
                    while (start < end && end_val == nums[end]) end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}