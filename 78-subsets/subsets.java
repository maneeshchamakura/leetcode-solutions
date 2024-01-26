class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subset_helper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void subset_helper(int[] nums, List<List<Integer>> result, List<Integer> answer, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // take the element
        answer.add(nums[index]);
        subset_helper(nums, result, answer, index+1);
        // don't take the element
        answer.remove(answer.size() - 1);
        subset_helper(nums, result, answer, index + 1);
    }
}