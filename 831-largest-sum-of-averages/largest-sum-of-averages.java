class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] prefix_sum = new int[n];
        int left_sum = 0;
        for (int i=0; i<n; i++) {
            left_sum += nums[i];
            prefix_sum[i] = left_sum;
        }
        return find_sums(nums, k, prefix_sum, 0, new HashMap<>());
    }

    double find_avg(int start, int end, int[] prefix_sum) {
        double sum;
        if (start == 0) {
            sum = prefix_sum[end];
        } else {
            sum = prefix_sum[end] - prefix_sum[start-1];
        }
        sum /= (end - start + 1);
        return sum;
    }

    double find_sums(int[] arr, int k, int[] prefix_sum, int index, Map<String, Double> map) {
        String key = index +"," + k;
        if (map.containsKey(key)) return map.get(key);
        if (index >= arr.length) return -1;
        if (k == 1) {
            double avg = find_avg(index, arr.length - 1, prefix_sum);            
            return avg;
        }
        double max=0.0;       
        for (int len = 1; len <= arr.length - index; len++) {
            double avg = find_avg(index, index + len - 1, prefix_sum);
            double next_avg = find_sums(arr, k - 1, prefix_sum, index + len, map);
            if (next_avg != -1)
            max = Math.max(max, avg + next_avg);
        }
        map.put(key, max);
        return max;
    }
}