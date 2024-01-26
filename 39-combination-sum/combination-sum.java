class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, result, 0, target, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result, int start, int remain, List<Integer> chosen) {
        if (remain < 0) return;
        else if (remain == 0) {
            result.add(new ArrayList<>(chosen));
            return;
        } else {
            for (int i=start; i < nums.length; i++) {
                chosen.add(nums[i]);
                backtrack(nums, result, i, remain - nums[i], chosen); // not i+1 
                // because we can choose the same element again
                chosen.remove(chosen.size() - 1);
            }
        }
    }
}