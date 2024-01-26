class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int low = start, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                result.add(Arrays.asList(nums[low], nums[high]));
                // ignore the duplicate ones
                int low_val = nums[low], high_val = nums[high];
                while (low < high && nums[low] == low_val) {
                    low++;
                }
                while (low < high && nums[high] == high_val) high--;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;
        long avg_value = target/k;
        if (nums[start] > avg_value || nums[nums.length - 1] < avg_value) return res;
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            for(List<Integer> subset: kSum(nums, target - nums[i], i + 1, k-1)) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(subset);
            }
        }
        return res;
    }
}