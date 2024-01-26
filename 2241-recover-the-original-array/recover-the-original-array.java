class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length/2];
        int prev = 0;
        for (int i=1; i < nums.length; i++) {
            int diff = nums[i] - nums[0];
            // possible answer for the diff
            // should be 2k
            if (diff != prev && diff > 0 && diff % 2 == 0 && check(res, i, diff/2, nums)) {
                break;
            }
            prev = diff;
        }
        return res;
    }

    public boolean check(int[] res, int j, int k, int[] nums) {
        int idx = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int target = nums[i] + 2*k;
            while(j < nums.length && (nums[j] < target || (nums[j] == target && visited[j]))) j++;
            if (j == nums.length || nums[j] != target) return false;
            visited[j] = true;
            res[idx++] = nums[i] + k;
        }
        return true;
    }
}