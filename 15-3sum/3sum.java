class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0; i <= n-3; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int first = nums[i];
                int sum = first*-1;
                // find a pair with sum sum
                int left=i+1, right=n-1;
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        list.add(Arrays.asList(first, nums[left], nums[right]));
                        while (left+1 < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (right-1 > left && nums[right] == nums[right- 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}