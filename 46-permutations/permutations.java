class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }
    public void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> sol = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(sol);
            return;
        }
        for (int i=start; i<nums.length; i++) {
            // swap i and start
            swap(nums, i, start);
            backtrack(nums, start + 1, result);
            swap(nums, i, start);
        }        
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}