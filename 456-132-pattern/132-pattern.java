class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int[] smallLeft = new int[n];
        smallLeft[0] = nums[0];
        for (int i=1; i<n; i++) {
            smallLeft[i] = Math.min(smallLeft[i-1], nums[i]);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=n-2; i>0; i--) {
            set.add(nums[i+1]);
            int currentIndex = i;
            if (smallLeft[i-1] >= nums[currentIndex]) continue;
            int leftVal = smallLeft[i-1];
            Integer val = set.lower(nums[currentIndex]);
            if (val != null && val > leftVal) return true;
        }
        return false;
    }
}