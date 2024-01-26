class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = Arrays.stream(nums1).asLongStream().sum();
        long zero_count1 = 0L;
        long zero_count2 = 0L;
        for (int num: nums1) {
            // sum1 += num;
            if (num == 0) zero_count1++;
        }
        long sum2 = 0L;
        for (int num: nums2) {
            sum2 += num;
            if (num == 0) zero_count2++;
        }
        sum1 += zero_count1;
        sum2 += zero_count2;
        boolean is_max_inf1 = zero_count1 > 0;
        boolean is_max_inf2 = zero_count2 > 0;
        if (is_max_inf1 && is_max_inf2) {
            return Math.max(sum1, sum2);
        } else if (is_max_inf1) {
            if (sum2 < sum1) return -1;
            return Math.max(sum1, sum2);
        } else if (is_max_inf2) {
            if (sum1 < sum2) return -1;
            return Math.max(sum1, sum2);
        } else {
            return sum1 == sum2 ? sum1: -1;
        }
    }
}