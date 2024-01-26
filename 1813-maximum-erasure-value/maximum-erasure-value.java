class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // find the prefix sums
        if (nums == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // prefix sum
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i=1; i<n; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }
        // sliding window
        int start=0, end=0;
        int result = nums[0];
        map.put(nums[0], 0);
        int sum_so_far = nums[0];
        while (end < n-1){
            end++;
            // check whether this fits in 
            int current = nums[end];
            if (map.containsKey(current) && map.get(current) >= start) {
                // slide the start of the window to the
                int current_index = map.get(current);
                // find the sum between start and map.get(current)
                int ind1=start, ind2=map.get(current);
                int temp_sum = prefix[ind2] - prefix[ind1] + nums[ind1];
                sum_so_far -= temp_sum;
                start = ind2+1;
            }
            map.put(current, end);
            sum_so_far += current;
            if (sum_so_far > result) result = sum_so_far;
        }
        return result;
    }
}