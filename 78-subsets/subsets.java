class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        createSubsets(nums, result, 0, new ArrayList<>());
        return result;
    }
    
    public void createSubsets(int[] nums, List<List<Integer>> result, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        createSubsets(nums, result, index+1, list);
        list.remove(list.size() - 1);
        
        createSubsets(nums, result, index+1, list);
    }
}