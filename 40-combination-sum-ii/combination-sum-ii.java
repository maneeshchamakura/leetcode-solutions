class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int remain, int start, List<List<Integer>> result, List<Integer> chosen) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(chosen));
            return;
        } else {
            for (int i= start; i<nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                chosen.add(nums[i]);
                // skip the duplicates
                backtrack(nums,  remain - nums[i], i+1, result, chosen);
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}