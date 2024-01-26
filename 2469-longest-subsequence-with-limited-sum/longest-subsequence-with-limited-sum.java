class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        // find prefix sum
        int n = nums.length;
        long[] prefix_sum = new long[n];
        long sum = 0L;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            prefix_sum[i] = sum;
        }
        int m = queries.length;
        int[] result = new int[m];
        long min = prefix_sum[0];
        for (int i=0; i<m; i++) {
            // find the index for the queries[i]
            int target = queries[i];
            if (target < min) continue;
            // definitely there will be a value
            result[i] = find_first_greater_than(prefix_sum, target);
        }
        return result;
    }
    
    // [1, 2, 4, 5]
    // [1, 3, 7, 12]
    // low = 0 high = 3
    // mid = 1
    // arr[1] 
    // [3, 10, 21]
    
    public int find_first_greater_than(long[] arr, int target) {
        // find the first element greater than target
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] > target) {
                // low high diff is 1
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low == arr.length) return low;
        return arr[low] > target ? low: low + 1;
        // 1 2 13 14 15
    }
}