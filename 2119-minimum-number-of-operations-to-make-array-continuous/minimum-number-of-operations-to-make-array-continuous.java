class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int[] uniq = new int[set.size()];
        int index = 0;
        for (int num: set) {
            uniq[index++] = num;
        }
        Arrays.sort(uniq);
        int n = nums.length;
        int ans = n;
        for(int i=0; i< uniq.length; i++) {
            int left = uniq[i];
            int right = left + n - 1;
            int j = custom_binarysearch(uniq, right);
            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        return ans;
    }

    public int custom_binarysearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high)/2;
            if (target < nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}