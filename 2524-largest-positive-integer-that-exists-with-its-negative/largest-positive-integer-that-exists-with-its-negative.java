class Solution {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for(int num: nums) {
            if (num > 0) {
                // check for -num
                if (set.contains(-num)) {
                    if (ans == -1) {
                        ans = num;
                    } else if (num > ans){
                        ans = num;
                    }
                }
            }
        }
        return ans;
    }
}