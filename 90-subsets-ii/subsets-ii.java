class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset2(0, nums, result, new ArrayList<>());
        return result;
    }

    public void subset2(int i, int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // choose the number
        temp.add(nums[i]);
        subset2(i+1, nums, result, temp);

        // don't choose the number
        temp.remove(temp.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i+1]) i+= 1;
        subset2(i+1, nums, result, temp);
        return;
    }
}