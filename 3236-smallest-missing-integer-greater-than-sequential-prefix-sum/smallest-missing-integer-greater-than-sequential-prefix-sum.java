class Solution {
    public int missingInteger(int[] nums) {
        List<Integer> alist = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int n = alist.size();
        Set<Integer> set1 = new HashSet<>(alist);
        // find the length of the longest 
        int i=1;
        int sum = nums[0];
        while(i < nums.length && nums[i] == nums[i-1] + 1) {
            sum += nums[i];
            i++;
        }
        // find the i 
        // i-1
        // find num >= sum
        int start = sum;
        while (true) {
            if (!set1.contains(sum)) {
                return sum;
            }
            sum++;
        }
        // return -1;
    }
}