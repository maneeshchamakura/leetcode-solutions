class Solution {
    public boolean find132pattern(int[] nums) {
        // find the pattern
        if (nums == null || nums.length < 3) return false;
        int n = nums.length;
        int[] leftSmall = new int[n];
        leftSmall[0] = nums[0];
        for(int i=1; i<n; i++) {
            leftSmall[i] = Math.min(leftSmall[i-1], nums[i]);
        }
        TreeSet<Integer> set = new TreeSet<>();        
        for (int i=n-2; i> 0; i--) {
            set.add(nums[i+1]);
            int currentIndex = i;
            // currentIndex is the j index
            if (leftSmall[i-1] >= nums[currentIndex]) continue;
            int leftVal = leftSmall[i-1];
            // find the k index
            Integer val = set.lower(nums[currentIndex]);
            if (val != null && val > leftVal) return true;
        }
        return false;
    }
}