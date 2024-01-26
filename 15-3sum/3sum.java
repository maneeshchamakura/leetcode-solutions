class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        // use the two pointer approach
        // fix one element and apply two sum logic here
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0; i<n-2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // NOTE: fix i as the first element
            int first = nums[i];
            // now use two pointer approach
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = nums[low] + nums[high] + first;
                if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    results.add(Arrays.asList(first, nums[low], nums[high]));
                    int low_val = nums[low];
                    int high_val = nums[high];
                    // we will ignore the duplicate values here
                    while (low < high && nums[low] == low_val) low++;
                    while (low < high && nums[high] == high_val) high--;
                }
            }
        }
        return results;
    }
}